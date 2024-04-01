package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.Workflow.domain.BpmJob;
import biz.picosoft.demo.Workflow.service.WorkflowService;
import biz.picosoft.demo.client.kernel.intercomm.KernelInterface;
import biz.picosoft.demo.client.kernel.intercomm.KernelService;
import biz.picosoft.demo.client.kernel.model.RulesDTO;
import biz.picosoft.demo.client.kernel.model.acl.AclClass;
import biz.picosoft.demo.client.kernel.model.acl.Permission;
import biz.picosoft.demo.client.kernel.model.acl.enumeration.Access;
import biz.picosoft.demo.client.kernel.model.global.CurrentUser;
import biz.picosoft.demo.client.kernel.model.objects.ObjectDTO;
import biz.picosoft.demo.client.kernel.model.objects.ObjectState;
import biz.picosoft.demo.client.kernel.model.objects.ObjectsDTO;
import biz.picosoft.demo.client.kernel.model.objects.WFDTO;
import biz.picosoft.demo.client.kernel.model.pm.ActivityType;
import biz.picosoft.demo.client.kernel.model.pm.Role;
import biz.picosoft.demo.controller.errors.BadRequestAlertException;
import biz.picosoft.demo.controller.errors.ECErrors;
import biz.picosoft.demo.controller.errors.RCErrors;
import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.repository.DemandeRepository;
import biz.picosoft.demo.service.DemandeService;

import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.DemandeInputDTO;
import biz.picosoft.demo.service.dto.DemandeOutputDTO;
import biz.picosoft.demo.service.mapper.DemandeInputMapper;
import biz.picosoft.demo.service.mapper.DemandeMapper;

import biz.picosoft.demo.service.mapper.DemandeOutputMapper;
import freemarker.template.TemplateException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Service Implementation for managing {@link Demande}.
 */
@Service
@Transactional
public class DemandeServiceImpl implements DemandeService {

    private final Logger log = LoggerFactory.getLogger(DemandeServiceImpl.class);

    private final KernelService kernelService;
    private final DemandeRepository demandeRepository;
    private final ClientRepository clientRepository;
    private final DemandeMapper demandeMapper;

    private final KernelInterface kernelInterface;
    private final DemandeOutputMapper demandeOutputMapper;
    private final DemandeInputMapper demandeInputMapper;
    private final WorkflowService workflowService;

    private final CurrentUser currentUser;

//    private RulesService rulesService;


    public DemandeServiceImpl(DemandeRepository demandeRepository, DemandeMapper demandeMapper,ClientRepository clientRepository,DemandeOutputMapper demandeOutputMapper,
                              WorkflowService workflowService,CurrentUser currentUser,KernelService kernelService,KernelInterface kernelInterface,
                              DemandeInputMapper demandeInputMapper
//                             , RulesService rulesService
    ) {
        this.demandeRepository = demandeRepository;
        this.demandeMapper = demandeMapper;
        this.clientRepository=clientRepository;
        this.workflowService=workflowService;
        this.demandeOutputMapper=demandeOutputMapper;
        this.currentUser=currentUser;
        this.kernelInterface=kernelInterface;
        this.kernelService=kernelService;
        this.demandeInputMapper=demandeInputMapper;

    }

    @Override
    public DemandeDTO save(DemandeDTO demandeDTO) {
        log.debug("Request to save Demande : {}", demandeDTO);
        Demande demande = demandeMapper.toEntity(demandeDTO);
        demande = demandeRepository.save(demande);
        return demandeMapper.toDto(demande);
    }

    @Override
    public DemandeDTO update(DemandeDTO demandeDTO) {
        log.debug("Request to save Demande : {}", demandeDTO);
        Demande demande = demandeMapper.toEntity(demandeDTO);
        demande = demandeRepository.save(demande);
        return demandeMapper.toDto(demande);
    }

    @Override
    public Optional<DemandeDTO> partialUpdate(DemandeDTO demandeDTO) {
        log.debug("Request to partially update Demande : {}", demandeDTO);

        return demandeRepository
            .findById(demandeDTO.getId())
            .map(existingDemande -> {
                demandeMapper.partialUpdate(existingDemande, demandeDTO);

                return existingDemande;
            })
            .map(demandeRepository::save)
            .map(demandeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DemandeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Demandes");
        return demandeRepository.findAll(pageable).map(demandeMapper::toDto);
    }


    public Page<DemandeDTO> findAllWithEagerRelationships(Pageable pageable) {
        return demandeRepository.findAllWithEagerRelationships(pageable).map(demandeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DemandeDTO> findOne(Long id) {
        log.debug("Request to get Demande : {}", id);
        return demandeRepository.findOneWithEagerRelationships(id).map(demandeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Demande : {}", id);
        demandeRepository.deleteById(id);
    }

    @Override
    public Demande saveAndAssignToClient(Demande demandeDTO, Long clientId) {
        log.debug("Request to save Demande and assign to Client: {}", demandeDTO);
       // Demande demande = demandeMapper.toEntity(demandeDTO);

        // Fetch the Client from the database
        Client client = clientRepository.findById(clientId).get();
        if (client!=null) {
            demandeDTO.setClient(client);
            demandeRepository.save(demandeDTO);
        } else {
            throw new IllegalArgumentException("Client with id " + clientId + " not found.");
        }

        return demandeDTO;
    }

    @Override
    public Page<Demande> findAllDemande(Pageable pageable) {
        return demandeRepository.findAll(pageable);
    }

    @Override
    public Demande getById(Long id) {
        log.debug("Request to get Demande : {}", id);
        return demandeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Demande with id " + id + " not found."));

    }

    @Override
    public Demande updateAndAssignToClient(Long demandeId, Long clientId, DemandeDTO updatedDemandeDTO) {
        log.debug("Request to update Demande with ID {} and assign to Client with ID {}", demandeId, clientId);

        // Fetch the existing demand from the database
        Demande existingDemande = demandeRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Demande with id " + demandeId + " not found."));

        // Fetch the client from the database
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client with id " + clientId + " not found."));

        // Update the demand with new information
        Demande updatedDemande = demandeMapper.toEntity(updatedDemandeDTO);
        updatedDemande.setId(demandeId); // Ensure the ID is set to the correct value

        // Assign the demand to the fetched client
        updatedDemande.setClient(client);

        // Save the updated demand
        return demandeRepository.save(updatedDemande);
    }

    @Override
    public Boolean checkRole(String profile, String roleName) {
        if (profile == null)
            throw new BadRequestAlertException(
                    RCErrors.ERR_Msg_profile_not_found,
                    RCErrors.Entity_requestCase,
                    RCErrors.ERR_Key_profile_not_found);
        List<Role> roles = kernelService.findAllByProfiles(profile);
        List<String> rolesName = new ArrayList<>();
        for (Role role : roles)
            rolesName.add(role.getName());
        if (!rolesName.contains(roleName))
            throw new BadRequestAlertException(
                    RCErrors.ERR_Msg_not_authorized,
                    RCErrors.Entity_requestCase,
                    RCErrors.ERR_Key_not_authorized);
        return true;
    }

    @Override
    public DemandeOutputDTO getbyideDTO(Long id) {
        DemandeOutputDTO result = null;
        try {
            result = proceedGetDemandeId(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
        kernelInterface.addUserActivity(ActivityType.READ, id, result.getClassName(), "", "");
        return result;

    }
    public DemandeOutputDTO proceedGetDemandeId(Long id) throws IOException, TemplateException {
        log.debug("Request to get MmInbound : {}", id);

        DemandeOutputDTO demandeOutputDTO = new DemandeOutputDTO();

        // check request case existance
        Optional<Demande> o = demandeRepository.findById(id);
        if (!o.isPresent())
            throw new BadRequestAlertException(
                    RCErrors.ERR_Key_requestCase_null,
                    RCErrors.Entity_requestCase,
                    RCErrors.ERR_Msg_requestCase_null);

        // check acl class existance
        AclClass aclClass = kernelInterface.getaclClassByClassName(Demande.class.getName());
        if (aclClass == null)
            throw new BadRequestAlertException(
                    RCErrors.ERR_Msg_requestCase_null,
                    RCErrors.Entity_requestCase,
                    RCErrors.ERR_Key_requestCase_null);


        List<String> authorsSid = new ArrayList<>();
        List<String> readersSid = new ArrayList<>();
        Set<String> authorsSet = kernelInterface.findAllWhriteSids(aclClass.getId(), o.get().getId());
        Set<String> readersSet = kernelInterface.findAllReadSids(aclClass.getId(), o.get().getId());
        Set<String> tempReadersSet = kernelInterface.findAllTempReadSids(aclClass.getId(), o.get().getId());

        authorsSid = new ArrayList<>(authorsSet);
        List<String> readers = new ArrayList<>(readersSet);
        List<String> tempReaders = new ArrayList<>(tempReadersSet);
        readersSid.addAll(readers);
        readersSid.addAll(tempReaders);

        String permission = Permission.NONE.name();
        permission = kernelInterface.checkSecurity(aclClass.getSimpleName(), id, currentUser.getSid());
        Access access = Access.Direct;
        if (permission.equals(Permission.NONE.name()))
            access = kernelInterface.checkAccess(authorsSid, readersSid, o.get().getSecuriteLevel());

        if (permission.equals(Permission.NONE.name()) && access.equals(Access.NoAccess) && o.get().getSecuriteLevel().equals(0)) {
            permission = Permission.READ.name();
        } else if (permission.equals(Permission.NONE.name()) && access.equals(Access.NoAccess) && !o.get().getSecuriteLevel().equals(0)) {
            throw new BadRequestAlertException(
                    RCErrors.ERR_Msg_not_authorized,
                    RCErrors.Entity_requestCase,
                    RCErrors.ERR_Key_not_authorized);
        } else if (permission.equals(Permission.NONE.name()) && access.equals(Access.AuthorIndirect)) {
            permission = Permission.WRITE.name();
        } else if (permission.equals(Permission.NONE.name()) && access.equals(Access.ReaderIndirect)) {
            permission = Permission.READ.name();
        }
        //set file access token
        String datetimeExpiry = LocalDateTime.now().plusHours(1).toString();
        String objectId = o.get().getId().toString();
        String classId = aclClass.getId().toString();
        String userSecurityLevel = currentUser.getProfileSecuriteLevel().toString();
        String strToEncrypt = datetimeExpiry + "," + objectId + "," + classId + "," + userSecurityLevel + "," + permission;
        String accesToken = kernelService.encryptFileAccessToken(strToEncrypt);

        //input for globalObject
        ObjectDTO objectDTO = new ObjectDTO();
        objectDTO.setObjectId(o.get().getId());
        objectDTO.setObject(o.get());
        objectDTO.setWfProcessId(o.get().getWfProcessID());
        objectDTO.setAccessToken(accesToken);
        if ((aclClass != null)) {
            objectDTO.setClassId(aclClass.getId());
            ObjectsDTO g = kernelInterface.getobjectsDto(objectDTO);

            demandeOutputDTO = demandeOutputMapper.toDto(o.get());
            demandeOutputDTO = this.setObjectInOutPutDTO(g, demandeOutputDTO);
            demandeOutputDTO.setUserPermission(permission);
            if (!permission.equals((Permission.WRITE.name()))) {
                WFDTO wfdtoWithOutDecision = demandeOutputDTO.getWorkflow();
                if (demandeOutputDTO.getWorkflow() != null) {
                    wfdtoWithOutDecision.setDecisionsWF(new ArrayList<>());
                    demandeOutputDTO.setWorkflow(wfdtoWithOutDecision);
                    demandeOutputDTO.setWfProcessName(demandeOutputDTO.getWorkflow().getWfProcessName());
                }
            }

        }
        return demandeOutputDTO;

    }
    public DemandeOutputDTO setObjectInOutPutDTO(ObjectsDTO g, DemandeOutputDTO requestCaseOutputDTO) throws IOException, TemplateException {
        requestCaseOutputDTO.setClassName(g.getClassName());
        requestCaseOutputDTO.setClassId(g.getClassId());
        requestCaseOutputDTO.setLabelClass(g.getLabelClass());
        requestCaseOutputDTO.setSimpleClassName(g.getSimpleClassName());
        requestCaseOutputDTO.setAttachements(g.getAttachements());
        requestCaseOutputDTO.setEvents(g.getEvents());
        requestCaseOutputDTO.setUserActivity(g.getUserActivity());
        requestCaseOutputDTO.setUserPermission(g.getUserPermission());
        requestCaseOutputDTO.setCurrentState(g.getCurrentState());
        requestCaseOutputDTO.setFormSource(g.getFormSource());
        requestCaseOutputDTO.setWorkflow(g.getWorkflow());
        requestCaseOutputDTO.setRemaingRequestFileDefinitions(g.getRemaingRequestFileDefinitions());

        requestCaseOutputDTO.setMandatoryTemplateFileName(g.getMandatoryTemplateFileName());
        requestCaseOutputDTO.setDefaultTemplateFileName(g.getDefaultTemplateFileName());
        requestCaseOutputDTO.setEmailTemplateFileName(g.getEmailTemplateFileName());
        requestCaseOutputDTO.setOfficeTemplateFileName(g.getOfficeTemplateFileName());
        requestCaseOutputDTO.setOptionalTemplateFileName(g.getOptionalTemplateFileName());

        requestCaseOutputDTO.setSecurity(g.getSecurity());
        requestCaseOutputDTO.setComponents(g.getComponents());

        return requestCaseOutputDTO;
    }


    // process methode


    @Transactional
    public DemandeOutputDTO initProcessDemande(AclClass aclClass) throws Exception {

        // check existance of extracted acl class
        if (aclClass == null)
            throw new BadRequestAlertException(RCErrors.ERR_Msg_AclClass_null, RCErrors.Entity_requestCase, RCErrors.ERR_Key_AclClass_null);

        // initiate new object Courrier
        Demande demande = new Demande();

        demande.setDateDeCreation(ZonedDateTime.now());

        // persite the object
        demande = demandeRepository.save(demande);

        // map entity courrier to output DTO
        DemandeOutputDTO demandeOutputDTO = demandeOutputMapper.toDto(demande);

        demandeOutputDTO.setClassId(aclClass.getId());

        demandeOutputDTO.setClassName(aclClass.getClasse());

        demandeOutputDTO.setLabelClass(aclClass.getLabel());

        demandeOutputDTO.setSimpleClassName(aclClass.getSimpleName());

        // send variables to start new process instance
        BpmJob bpmJob = workflowService.startProcessInstanceWithoutEvent(currentUser.getEmployeSid(), aclClass.getFwProcess(), demandeOutputDTO);

        List<String> authors = bpmJob.getAuthors();

        List<String> readers = bpmJob.getReaders();

        demandeOutputDTO = (DemandeOutputDTO) bpmJob.getDataObject();

        demande = demandeOutputMapper.toEntity(demandeOutputDTO);

        demande.setWfProcessID(bpmJob.getProcessID());
        System.out.println("getProcessID"+bpmJob.getProcessID());
        demande.setActivityName(bpmJob.getActivityName());
        System.out.println("bpmJob.getActivityName()"+bpmJob.getActivityName());
        demande.setEndProcess(bpmJob.getEndProcess());
        System.out.println("bpmJob.getEndProcess()"+bpmJob.getEndProcess());
        demande.setAssignee(bpmJob.getAssignee() != null ? bpmJob.getAssignee() : null);
        System.out.println("bpmJob.getAssignee()"+bpmJob.getAssignee());
        demande.setDemandeNumber(kernelInterface.getSequenceNumberByName(new JSONObject(demande), aclClass.getSequenceNameFM()));

        demande = saveDemande(demande, authors, readers, aclClass, true);
 System.out.println("demande object"+demande);
        return demandeOutputMapper.toDto(demande);
    }
    public Demande saveDemande(Demande demande) {
        Demande requestCase1 = demandeRepository.save(demande);

//        if (requestCase.getEntityDetails() != null) {
//            for (EntityDetails entityDetails : requestCase.getEntityDetails()) {
//                if (entityDetails.getId()!=null){
//                    EntityDetails entityDetailsold = entityDetailsRepository.findById(entityDetails.getId()).get() ;
//                    entityDetails.setEntityCase(entityDetailsold.getEntityCase());
//                }
//
//
//                entityDetails.setRequestCase(requestCase);
//                entityDetailsRepository.save(entityDetails);
//            }
//        }
//
//        if (requestCase.getLawyerDetails() != null) {
//            for (LawyerDetails lawyerDetails : requestCase.getLawyerDetails()) {
//                if (lawyerDetails.getId()!=null){
//                    LawyerDetails lawyerDetailsold = lawyerDetailsRepository.findById(lawyerDetails.getId()).get() ;
//                    lawyerDetails.setEntityCase(lawyerDetailsold.getEntityCase());
//
//                }
//                lawyerDetails.setRequestCase(requestCase);
//                lawyerDetailsRepository.save(lawyerDetails);
//            }
//        }

        return requestCase1;
    }
    public Demande saveDemande(Demande demande, List<String> authors, List<String> readers, AclClass aclClass, Boolean isCreated) {
        log.debug("Request to save Courrier : {}", demande);

        if (isCreated) {

            if (demande.getSecuriteLevel() == null) demande.setSecuriteLevel(aclClass.getSecuriteLevel());


            demande = setDefaultStateCourrier(demande, aclClass);

            demande = saveRequestCaseAndflush(demande);

            if (authors != null && readers != null && demande.getId() != null)
                kernelService.applySecurity(aclClass.getClasse(), demande.getId(), authors, readers, new ArrayList<>(), null, null, isCreated, false);
        } else {
            Demande demandeRecent = demandeRepository.findById(demande.getId()).get();

            if (demandeRecent.getWfProcessID() != null)
                demande.setWfProcessID(demandeRecent.getWfProcessID());

            if (demandeRecent.getDemandeNumber() != null)
                demande.setDemandeNumber(demandeRecent.getDemandeNumber());

            if (!demandeRecent.isExcludeFromView())
                demande.setExcludeFromView(demandeRecent.isExcludeFromView());

            if (demande.getActivityName() == null || (demande.getActivityName() != null && demande.getActivityName().equals("null")))
                demande.setActivityName(demandeRecent.getActivityName());

            if (demande.getSecuriteLevel() == null)
                demande.setSecuriteLevel(demandeRecent.getSecuriteLevel());

            else if (!demandeRecent.getSecuriteLevel().equals(demande.getSecuriteLevel()))
                try {
                    kernelService.adjustAttachmentSecurity(aclClass.getId(), demandeRecent.getId(), demande.getSecuriteLevel());
                } catch (Exception e) {
                    log.error("error in adjustAttachmentSecurity " + e.getMessage());
                }

            try {
                Long numberOfAttachments = kernelInterface.countAttachements(demande.getId(), aclClass.getId());
                demande.setNumberOfattachments(numberOfAttachments);
            } catch (Exception e) {
                log.error(e.getMessage());
            }

            //compute zpl
            try {
                demande = setCurrentState(demande, aclClass);

                demande = saveDemande(demande);

                if (authors != null && readers != null && demande.getId() != null)
                    kernelService.applySecurity(aclClass.getClasse(), demande.getId(), authors, readers, new ArrayList<>(), null, null, isCreated, false);

            } catch (Exception e) {
                log.error(e.getMessage());
            }

        }

        return demande;
    }

    public Demande setDefaultStateCourrier(Demande demande, AclClass aclClass) {

        ObjectState objectState = new ObjectState();
        objectState.setBusinessClass(aclClass);
        objectState.setObjectId(demande.getId());
        if (aclClass.getDefaultState() == null)
            throw new BadRequestAlertException(
                    RCErrors.ERR_Msg_default_state_null,
                    RCErrors.Entity_requestCase,
                    RCErrors.ERR_Key_default_state_null);
        objectState.setCurrentState(aclClass.getDefaultState());
        kernelService.saveObjectState(objectState);
        // objectStateRepository.save(objectState);
        demande.setStatus(aclClass.getDefaultState().getLabel());
        return demande;
    }

    public Demande saveRequestCaseAndflush(Demande requestCase) {
        Demande demande1 = demandeRepository.saveAndFlush(requestCase);


//        if (requestCase.getEntityDetails() != null) {
//            for (EntityDetails entityDetails : requestCase.getEntityDetails()) {
//                entityDetails.setRequestCase(requestCase);
//                entityDetailsRepository.save(entityDetails);
//            }
//        }
//
//        if (requestCase.getLawyerDetails() != null) {
//            for (LawyerDetails lawyerDetails : requestCase.getLawyerDetails()) {
//                lawyerDetails.setRequestCase(requestCase);
//                lawyerDetailsRepository.save(lawyerDetails);
//            }
//        }

        return demande1;
    }

    public Demande setCurrentState(Demande demande, AclClass aclClass) {
        Optional<ObjectState> objectState = kernelService.getObjectStateCourrier(demande.getId(), aclClass.getClasse());
        if (objectState.isPresent()) {
            demande.setStatus(objectState.get().getCurrentState().getLabel());
        }
        return demande;
    }
    @PersistenceContext(unitName = "externDSEmFactory")
    private EntityManager entityManager;
    // submit methods
    @Transactional
    public DemandeOutputDTO submitProcessDemande(DemandeInputDTO demandeInputDTO, AclClass aclClass) throws Exception {

        entityManager.clear();
        // extract object by id from data base
        Optional<Demande> demandeOptional = demandeRepository.findById(demandeInputDTO.getId());

        // extract courrier
        Demande requestCase = demandeOptional.get();

        // check if the object exist in database
        if (!demandeOptional.isPresent())
            throw new BadRequestAlertException(RCErrors.ERR_Msg_requestCase_null, RCErrors.Entity_requestCase, RCErrors.ERR_Key_requestCase_null);

        // extract permission of the authentifier from kernel
        String permission = kernelService.checkSecurity(aclClass.getSimpleName(), demandeInputDTO.getId(), currentUser.getSid());

        // check if the authentifier has permission WRITE
        if (!permission.equals(Permission.WRITE.name()) && !permission.equals(Permission.INH_WRITE.name()))
            throw new BadRequestAlertException(RCErrors.ERR_Msg_not_authorized, RCErrors.Entity_requestCase, RCErrors.ERR_Key_not_authorized);

        // validate attributes courrier
        this.validateRequestCase(aclClass, demandeInputDTO);

        // extract activity name from courrier
        String activityName = requestCase.getActivityName();

        // fusion the input object and the object from database
        demandeInputMapper.partialUpdate(requestCase, demandeInputDTO);

        // map object courrier to courrier by id DTO
        DemandeOutputDTO requestCaseOutputDTO = demandeOutputMapper.toDto(requestCase);

        requestCaseOutputDTO.setClassId(aclClass.getId());

        requestCaseOutputDTO.setClassName(aclClass.getClasse());

        requestCaseOutputDTO.setLabelClass(aclClass.getLabel());

        requestCaseOutputDTO.setSimpleClassName(aclClass.getSimpleName());

        // initialize workflow information
        WFDTO workflow = new WFDTO();
        workflow.setWfProcessID(requestCase.getWfProcessID());
        workflow.setActivityName(requestCase.getActivityName());
        requestCaseOutputDTO.setWorkflow(workflow);

        BpmJob bpmJob = workflowService._nextTaskWithoutEvent(requestCase.getWfProcessID(), demandeInputDTO.getDecision(), demandeInputDTO.getWfComment(), requestCaseOutputDTO, aclClass);

        List<String> authors = bpmJob.getAuthors();

        List<String> readers = bpmJob.getReaders();

        requestCaseOutputDTO = (DemandeOutputDTO) bpmJob.getDataObject();

        requestCase = demandeOutputMapper.toEntity(requestCaseOutputDTO);

        requestCase.setWfProcessID(bpmJob.getProcessID());

        requestCase.setActivityName(bpmJob.getActivityName());

        requestCase.setEndProcess(bpmJob.getEndProcess());

        requestCase.setAssignee(bpmJob.getAssignee() != null ? bpmJob.getAssignee() : null);

        requestCase = saveDemande(requestCase, authors, readers, aclClass, false);

        return demandeOutputMapper.toDto(requestCase);

    }

    public Boolean validateRequestCase(AclClass aclClass, DemandeInputDTO demandeInputDTO) {

        String nameRule = "save-" + aclClass.getSimpleName();

        RulesDTO rulesDTO = kernelService.rulesByName(nameRule);
        if (rulesDTO != null && rulesDTO.getSrcCode() != null) {
            List<Object> objectList = new ArrayList<>();
            objectList.add(demandeInputDTO);
            try {
                System.out.println("zezezeze");
                //rulesService.executeRules(objectList, rulesDTO.getSrcCode());
            } catch (Exception e) {
                throw new BadRequestAlertException(
                        RCErrors.ERR_Msg_drools + ": " + nameRule,
                        aclClass.getSimpleName(),
                        RCErrors.ERR_Key_drools);
            }

        }

        if (demandeInputDTO.getMsg() == null)
            return true;
        else
            throw new BadRequestAlertException(
                    demandeInputDTO.getMsg(),
                    aclClass.getSimpleName(),
                    demandeInputDTO.getMsg());


    }



}
