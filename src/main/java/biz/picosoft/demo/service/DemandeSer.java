package biz.picosoft.demo.service;


import biz.picosoft.demo.client.kernel.intercomm.KernelInterface;
import biz.picosoft.demo.client.kernel.intercomm.KernelService;
import biz.picosoft.demo.client.kernel.model.acl.AclClass;
import biz.picosoft.demo.client.kernel.model.acl.Permission;
import biz.picosoft.demo.client.kernel.model.acl.enumeration.Access;
import biz.picosoft.demo.client.kernel.model.global.CurrentUser;
import biz.picosoft.demo.client.kernel.model.objects.ObjectDTO;
import biz.picosoft.demo.client.kernel.model.objects.ObjectState;
import biz.picosoft.demo.client.kernel.model.objects.ObjectsDTO;
import biz.picosoft.demo.client.kernel.model.objects.WFDTO;
import biz.picosoft.demo.client.kernel.model.pm.Role;
import biz.picosoft.demo.controller.errors.BadRequestAlertException;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.errors.DemandeErrors;
import biz.picosoft.demo.repository.DemandeRepository;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.mapper.DemandeMap;
import biz.picosoft.demo.service.mapper.DemandeMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class DemandeSer {
    private final Logger log = LoggerFactory.getLogger(DemandeSer.class);

    private final DemandeRepository demandeRepository;
    private final DemandeMap demandeMapper;
    private final CurrentUser currentUser;
    @Autowired
    private KernelInterface kernelInterface;
    @Autowired
    KernelService kernelService;
    @Autowired
    private EntityManager entityManager;


    public DemandeSer(DemandeRepository demandeRepository, DemandeMap demandeMapper, CurrentUser currentUser) {
        this.demandeRepository = demandeRepository;
        this.demandeMapper = demandeMapper;
        this.currentUser = currentUser;
    }
    public Long submitInvoice(DemandeDTO demandeDTO, AclClass aclClass) throws Exception {

        if (aclClass == null)
            throw new BadRequestAlertException(
                    DemandeErrors.ERR_Msg_Invoice_null,
                    DemandeErrors.Entity_Invoice,
                    DemandeErrors.ERR_Key_Invoice_null);

        String permission = kernelService.checkSecurity(aclClass.getSimpleName(), demandeDTO.getId(), currentUser.getSid());
        if (!permission.equals(Permission.WRITE.name()) && !permission.equals(Permission.INH_WRITE.name()))
            throw new BadRequestAlertException(
                    DemandeErrors.ERR_Msg_not_authorized,
                    DemandeErrors.Entity_Invoice,
                    DemandeErrors.ERR_Key_not_authorized);



        Optional<Demande> invoiceOptional = demandeRepository.findById(demandeDTO.getId());
        if (!invoiceOptional.isPresent()) {
            throw new BadRequestAlertException(
                    DemandeErrors.ERR_Msg_Invoice_null,
                    DemandeErrors.Entity_Invoice,
                    DemandeErrors.ERR_Key_Invoice_null);
        }
        String activityName = invoiceOptional.get().getActivityName();
        String wfprocessID = invoiceOptional.get().getWfProcessID();

        Demande demande = null;
        Optional<Demande> optionalInvoice=demandeRepository.findById(demandeDTO.getId());
        if(optionalInvoice.isPresent()) {
            //ppppp
            demandeMapper.partialUpdate(optionalInvoice.get(),demandeDTO);
            demande=optionalInvoice.get();
        } else {
            demande = demandeMapper.toEntity(demandeDTO);
        }
//        demande.setDraft(false);
        demande.setWfProcessID(wfprocessID);
        demande = this.saveDemande(demande, currentUser.getSid(), null, aclClass, currentUser);

        // TODO tags & tpref
//        if (invoiceInputDTO.getTags() != null)
//            this.setCourrierTags(aclClass, courrierCreateDto.getTags(), courrier, currentUser);
//        if (courrierCreateDto.getTpRefDtoList() != null)
//            this.setNatureCourrier(courrierCreateDto.getTpRefDtoList(), courrier);

        //set Desion, wfComment,authentifier and data(InboundByID inclus TaskByID)
        Map<String, Object> variables = new HashMap<>();
        variables.put("Decision", demandeDTO.getDecision());
        variables.put("description", demandeDTO.getWfCurrentComment());
        variables.put("autentifier", currentUser.getDisplayName());

        DemandeDTO invoiceOutputDTO = demandeMapper.toDto(demande);
        invoiceOutputDTO.setClassName(aclClass.getClasse());
        invoiceOutputDTO.setClassId(aclClass.getId());
        invoiceOutputDTO.setLabelClass(aclClass.getLabel());
        invoiceOutputDTO.setSimpleClassName(aclClass.getSimpleName());
        WFDTO workflow = new WFDTO();
        workflow.setWfProcessID(demande.getWfProcessID());
        invoiceOutputDTO.setWorkflow(workflow);

        variables.put("data", invoiceOutputDTO);

        //execuste nextTask
        //exexute drools preNextTask
        //get drools by

        String nameprocess = aclClass.getFwProcess();
        String decision = demandeDTO.getDecision();
        String ruleName = "name-rule-bpm-" + nameprocess + "-" + activityName + "-" + decision;
        System.out.println("ruleName//" + ruleName);
        ruleName = ruleName.replaceAll(" ", "");
        //get name rule
        try {
            Object nameRuleInput = kernelService.getInput(demande.getWfProcessID(), ruleName, "string");
            String nameRule;
            if (nameRuleInput == null) {
                nameRule = "bpm-" + nameprocess + "-" + activityName + "-" + decision;
                nameRule = nameRule.replaceAll(" ", "");
               // kernelService.rulesByName(nameRule);

            } else {
//                nameRule = (String) nameRuleInput;
//                RulesDTO rulesDTO = kernelService.rulesByName(nameRule);
//                if (rulesDTO != null && rulesDTO.getSrcCode() != null) {
//                    List<Object> objectList = new ArrayList<>();
//                    objectList.add(invoiceInputDTO);
//                    rulesService.executeRules(objectList, rulesDTO.getSrcCode());
//                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        kernelService._nextTask(variables);

        return demande.getId();


    }

    public void putBPMDemande(String stringInvoice, String className) throws JsonProcessingException, org.json.simple.parser.ParseException {

        AclClass aclClass = kernelInterface.getaclClassByClassName(className);
        if (aclClass == null) {
            throw new BadRequestAlertException(
                    DemandeErrors.ERR_Msg_Invoice_null,
                    DemandeErrors.Entity_Invoice,
                    DemandeErrors.ERR_Key_Invoice_null);
        }

        org.json.simple.JSONObject bpmJobJSONObject = (org.json.simple.JSONObject) new JSONParser().parse(stringInvoice);

        org.json.simple.JSONObject mmInboundJSONObject = (org.json.simple.JSONObject) new JSONParser().parse(bpmJobJSONObject.get("data").toString());

        List<String> authors = (List<String>) mmInboundJSONObject.get("authors");

        List<String> readers = (List<String>) mmInboundJSONObject.get("readers");

        ObjectMapper mapper =
                new ObjectMapper()
                        .registerModule(new ParameterNamesModule())
                        .registerModule(new Jdk8Module())
                        .registerModule(new JavaTimeModule()); // new module, NOT JSR310Module
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//ppppppp
        DemandeDTO object = mapper.readValue(mmInboundJSONObject.toString(), DemandeDTO.class);
        DemandeMap demandeMapper = (DemandeMap) Mappers.getMapper(DemandeMapper.class);
        Demande demande = demandeMapper.toEntity(object);
        String permission = kernelService.checkSecurity(aclClass.getSimpleName(), object.getId(), currentUser.getSid());
        if (!permission.equals(Permission.WRITE.name()) && !permission.equals(Permission.INH_WRITE.name()))
            throw new BadRequestAlertException(
                    DemandeErrors.ERR_Msg_not_authorized,
                    DemandeErrors.Entity_Invoice,
                    DemandeErrors.ERR_Key_not_authorized);
        String wfprocessID = bpmJobJSONObject.get("processID").toString();
        String activityName = bpmJobJSONObject.get("activityName").toString();
        Boolean endProcess = (Boolean) bpmJobJSONObject.get("endProcess");

        String assignee = bpmJobJSONObject.get("assignee") != null ? bpmJobJSONObject.get("assignee").toString() : null;
        demande.setWfProcessID(wfprocessID);
        demande.setActivityName(activityName);
        demande.setEndProcess(endProcess);
        demande.setAssignee(assignee);


        this.saveDemande(demande, authors, readers, aclClass, currentUser);


    }

    public DemandeDTO initDemande() throws JsonProcessingException {

        // check the existance of acl class
        AclClass aclClass = kernelInterface.getaclClassByClassName(Demande.class.getName());
        System.out.println("aclClass"+aclClass);
        if (aclClass == null) {
            throw new BadRequestAlertException("acl class not found", "demande", null);
        }

        // check the existance of the authentifier sid
        String employeSid=currentUser.getEmployeSid();
        if (employeSid == null)
            throw new BadRequestAlertException("employe sid not found", "demande", null);

        // check the existance of authentifier profile
        String profile=currentUser.getProfileName();
        System.out.println("profillllllllllllllllllllllllllllllllllllllllllllle"+profile);
        if(profile==null)
            throw new BadRequestAlertException("employe profile not found", "demande", null);

 boolean test;
        // check can if authentifier can create demande
        test = checkRole(currentUser.getProfileName(), kernelService.anf_invoice_role_canCreatedemande);
System.out.println("checkRole"+test);
        Long id = initProcess(aclClass, currentUser);
        System.out.println("initProcess"+id);
        DemandeDTO demandeDTO = findOneById(id, aclClass);
        System.out.println("demandeDTO"+demandeDTO);
        System.out.println("getWorkflow"+demandeDTO.getWorkflow());
        if (demandeDTO.getWorkflow() == null)
            throw new BadRequestAlertException(
                    DemandeErrors.ERR_Key_wf_null,
                    DemandeErrors.Entity_Invoice,
                    DemandeErrors.ERR_Msg_wf_null);
        return demandeDTO;

    }
    public DemandeDTO findOneById(Long id, AclClass aclClass) {
        log.debug("Request to get Invoice : {}", id);

        entityManager.clear();

        DemandeDTO demandeDTO = new DemandeDTO();

        Optional<Demande> o = demandeRepository.findById(id);
System.out.println("findbyid : " + o);
        if (!o.isPresent())
            throw new BadRequestAlertException(
                    DemandeErrors.ERR_Key_Invoice_null,
                    DemandeErrors.Entity_Invoice,
                    DemandeErrors.ERR_Msg_Invoice_null);


        ///veifier
        ObjectDTO objectDTO = new ObjectDTO();
        objectDTO.setObjectId(o.get().getId());
        objectDTO.setObject(o.get());
        objectDTO.setWfProcessId(o.get().getWfProcessID());
        String permission = Permission.NONE.name();

        System.out.println("objectDTOpermission  "+objectDTO+"permission"+permission);
        if ((aclClass != null)) {
            objectDTO.setClassId(aclClass.getId());
            ObjectsDTO g = kernelInterface.getobjectsDto(objectDTO);
            //check access after get security(list authors,readers)
            List<String> authorsSid = new ArrayList<>();
            List<String> readersSid = new ArrayList<>();
            if (g.getSecurity() != null) {
                //new ArrayList<>(sourceSet)
                authorsSid = new ArrayList<>(g.getSecurity().getAuthors());
                List<String> readers = new ArrayList<>(g.getSecurity().getReaders());
                List<String> tempReaders = new ArrayList<>(g.getSecurity().getTempreaders());
                readersSid.addAll(readers);
                readersSid.addAll(tempReaders);
            }


            permission = kernelInterface.checkSecurity(aclClass.getSimpleName(), id, currentUser.getSid());
            Access access = Access.Direct;
            //TODO check acces security level
//            if (permission.equals(Permission.NONE.name()))
//                access = kernelInterface.checkAccess(authorsSid, readersSid, o.get().getSecuriteLevel());


            if (permission.equals(Permission.NONE.name()) && access.equals(Access.NoAccess)) {
                throw new BadRequestAlertException(
                        DemandeErrors.ERR_Msg_not_authorized,
                        DemandeErrors.Entity_Invoice,
                        DemandeErrors.ERR_Key_not_authorized);
            } else if (permission.equals(Permission.NONE.name()) && access.equals(Access.AuthorIndirect)) {
                permission = Permission.WRITE.name();
            } else if (permission.equals(Permission.NONE.name()) && access.equals(Access.ReaderIndirect)) {
                permission = Permission.READ.name();
            }
            demandeDTO = demandeMapper.toDto(o.get());
            demandeDTO = this.setObjectINDDemandeDTO(g, demandeDTO);
            demandeDTO.setUserPermission(permission);
            if (!permission.equals((Permission.NONE.name()))) {
                WFDTO wfdtoWithOutDecision = demandeDTO.getWorkflow();
                System.out.println(wfdtoWithOutDecision);
                if (demandeDTO.getWorkflow() != null) {
                    wfdtoWithOutDecision.setDecisionsWF(new ArrayList<>());
                    demandeDTO.setWorkflow(wfdtoWithOutDecision);
                    System.out.println("demandeDTO.getWorkflow"+demandeDTO.getWorkflow());
                }
            }

        }
        //set file access token
        String datetimeExpiry = LocalDateTime.now().plusHours(1).toString();
        String objectId = o.get().getId().toString();
        String classId = aclClass.getId().toString();
        String userSecurityLevel = currentUser.getProfileSecuriteLevel().toString();
        String strToEncrypt = datetimeExpiry + "," + objectId + "," + classId + "," + userSecurityLevel + "," + permission;
        String fileAccesToken = kernelService.encryptFileAccessToken(strToEncrypt);

        // TODO  setFileAccessToken
        demandeDTO.setFileAccessToken(fileAccesToken);

        return demandeDTO;

    }
    public void setCurrentState(Demande demande, AclClass aclClass) {
        Optional<ObjectState> objectState = kernelService.getObjectState(demande.getId(), aclClass.getClasse());
        if (objectState.isPresent()) {
            demande.setStatus(objectState.get().getCurrentState().getLabel());
        }
        demandeRepository.save(demande);
    }


    public DemandeDTO setObjectINDDemandeDTO(ObjectsDTO g, DemandeDTO invoiceOutputDTO) {
        invoiceOutputDTO.setClassName(g.getClassName());
        invoiceOutputDTO.setClassId(g.getClassId());
        invoiceOutputDTO.setLabelClass(g.getLabelClass());
        invoiceOutputDTO.setSimpleClassName(g.getSimpleClassName());
        invoiceOutputDTO.setAttachements(g.getAttachements());
        invoiceOutputDTO.setEvents(g.getEvents());
        invoiceOutputDTO.setUserActivity(g.getUserActivity());
        invoiceOutputDTO.setUserPermission(g.getUserPermission());
        invoiceOutputDTO.setCurrentState(g.getCurrentState());
        invoiceOutputDTO.setFormData(g.getFormData());
        invoiceOutputDTO.setWorkflow(g.getWorkflow());
        invoiceOutputDTO.setRemaingRequestFileDefinitions(g.getRemaingRequestFileDefinitions());

        invoiceOutputDTO.setMandatoryTemplateFileName(g.getMandatoryTemplateFileName());
        invoiceOutputDTO.setDefaultTemplateFileName(g.getDefaultTemplateFileName());
        invoiceOutputDTO.setEmailTemplateFileName(g.getEmailTemplateFileName());
        invoiceOutputDTO.setOfficeTemplateFileName(g.getOfficeTemplateFileName());
        invoiceOutputDTO.setOptionalTemplateFileName(g.getOptionalTemplateFileName());

        invoiceOutputDTO.setSecurity(g.getSecurity());
        invoiceOutputDTO.setComponents(g.getComponents());
        return invoiceOutputDTO;
    }

    public Long initProcess(AclClass aclClass, CurrentUser currentUser) {
        if (aclClass == null) {
            throw new BadRequestAlertException(
                    DemandeErrors.ERR_Msg_Invoice_null,
                    DemandeErrors.Entity_Invoice,
                    DemandeErrors.ERR_Key_Invoice_null);
        }
        //Create Object & persisit
        Demande demande = new Demande();
        demande.setDateDeCreation(LocalDate.now());

        demande = this.saveDemande(demande, Collections.singletonList(currentUser.getEmployeSid()), new ArrayList<>(), aclClass, currentUser);

        DemandeDTO result = demandeMapper.toDto(demande);
        result.setClassName(aclClass.getClasse());
        result.setClassId(aclClass.getId());
        result.setLabelClass(aclClass.getLabel());
        result.setSimpleClassName(aclClass.getSimpleName());
        Map<String, Object> variables = new HashMap<>();
        variables.put("initiator", currentUser.getEmployeSid());
        variables.put("processKey", aclClass.getFwProcess());
        variables.put("data", result);
        System.out.println("initProcess"+variables);
        org.json.simple.JSONObject bpmJobJSONObject = kernelService.startProcessInstance(variables);
        System.out.println("initProcess222"+bpmJobJSONObject);
//        String wfprocessID = bpmJobJSONObject.get("processID").toString();
//        String activityName = bpmJobJSONObject.get("activityName").toString();
//        Boolean endProcess = (Boolean) bpmJobJSONObject.get("endProcess");
//        String assignee = bpmJobJSONObject.get("assignee") != null ? bpmJobJSONObject.get("assignee").toString() : null;
        String wfprocessID = bpmJobJSONObject.get("processID") != null ? bpmJobJSONObject.get("processID").toString() : null;
        String activityName = bpmJobJSONObject.get("activityName") != null ? bpmJobJSONObject.get("activityName").toString() : null;
        Boolean endProcess = bpmJobJSONObject.get("endProcess") != null ? (Boolean) bpmJobJSONObject.get("endProcess") : null;
        String assignee = bpmJobJSONObject.get("assignee") != null ? bpmJobJSONObject.get("assignee").toString() : null;

        result.setWfProcessID(wfprocessID);
        result.setActivityName(activityName);
        result.setEndProcess(endProcess);
        result.setAssignee(assignee);
        entityManager.clear();
        List<String> authors = (List<String>) bpmJobJSONObject.get("authors");

        List<String> readers = (List<String>) bpmJobJSONObject.get("readers");

        this.saveDemande(demandeMapper.toEntity(result),authors,readers,aclClass,currentUser) ;

        //reload record
        return demande.getId();
    }
    public Demande saveDemande(Demande demande,
                               List<String> authors,
                               List<String> readers,
                               AclClass aclClass, CurrentUser currentUser) {
        log.debug("Request to save demande : {}", demande);


        Boolean isCreated = false;
        if (demande.getId() == null) {
            isCreated = true;
        }
        if (isCreated == true) {

            demande.setSecuriteLevel(aclClass.getSecuriteLevel());

            demande = demandeRepository.saveAndFlush(demande);

//            this.setDefaultStateInvoice(invoice, aclClass);
        } else {
            Demande invoiceRecent = demandeRepository.findById(demande.getId()).get();
//            invoiceRecent.setDraft(false);
            if (invoiceRecent.getWfProcessID() != null)
                demande.setWfProcessID(invoiceRecent.getWfProcessID());
            if (invoiceRecent.getIdentifiant() != null)
                demande.setIdentifiant(invoiceRecent.getIdentifiant());
            if (demande.getActivityName() == null || demande.getActivityName().equals("null")) {
                demande.setActivityName(invoiceRecent.getActivityName());
            }
            // TODO security level
            if (demande.getSecuriteLevel() == null) {
                demande.setSecuriteLevel(invoiceRecent.getSecuriteLevel());
                if (!invoiceRecent.getSecuriteLevel().equals(demande.getSecuriteLevel())) {
                    try {
                        kernelService.adjustAttachmentSecurity(aclClass.getId(), invoiceRecent.getId(), demande.getSecuriteLevel());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
            try {
//                Long numberOfAttachments = kernelInterface.countAttachements(demande.getId(), aclClass.getId());
//                demande.setNumberOfattachments(numberOfAttachments);
            } catch (Exception e) {
            }


            // TODO compute zpl
//            try {
//                InvoiceOutputDTO invoiceOutputDTO = invoiceOutputMapper.toDto(invoiceRecent);
//                ComputeLabel computeLabel = new ComputeLabel();
//                computeLabel.setClassName(aclClass.getClasse());
//                computeLabel.setJsonInput(courrierByIdDTO);
//                String zplLabel = globalService.getZplComputeLabel(computeLabel);
//                if (zplLabel != null)
//                    courrier.setLabelZpl(zplLabel);
//                courrier = courrierRepository.save(courrier);
//            } catch (Exception e) {
//                log.error(e.getMessage());
//            }


        }
        this.setCurrentState(demande, aclClass);

        if (authors != null && readers != null && demande.getId() != null)
            kernelService.applySecurity(aclClass.getClasse(), demande.getId(), authors, readers, new ArrayList<>(), null, null, isCreated, false);

        return demande;
    }

    public Boolean checkRole(String profile, String roleName) {
        if (profile == null)
            throw new BadRequestAlertException(
                    DemandeErrors.ERR_Msg_profile_not_found,
                    DemandeErrors.Entity_Invoice,
                    DemandeErrors.ERR_Key_profile_not_found);
        List<Role> roles = kernelService.findAllByProfiles(profile);
        List<String> rolesName = new ArrayList<>();
        for (Role role : roles)
            rolesName.add(role.getName());
        if (!rolesName.contains(roleName))
            throw new BadRequestAlertException(
                    DemandeErrors.ERR_Msg_not_authorized,
                    DemandeErrors.Entity_Invoice,
                    DemandeErrors.ERR_Key_not_authorized);
        return true;
    }

}
