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
import biz.picosoft.demo.controller.errors.RCErrors;
import biz.picosoft.demo.domain.*;
import biz.picosoft.demo.repository.DemandeRepository;
import biz.picosoft.demo.repository.OffreRepository;
import biz.picosoft.demo.repository.OpportuniteRepository;
import biz.picosoft.demo.service.OpportuniteService;
import biz.picosoft.demo.service.dto.*;
import biz.picosoft.demo.service.mapper.OpportuniteInputMapper;
import biz.picosoft.demo.service.mapper.OpportuniteMapper;
import biz.picosoft.demo.service.mapper.OpportuniteOutputMapper;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Service Implementation for managing {@link Opportunite}.
 */
@Service
@Transactional
public class OpportuniteServiceImpl implements OpportuniteService {

    private final Logger log = LoggerFactory.getLogger(OpportuniteServiceImpl.class);

    private final OpportuniteRepository opportuniteRepository;

    private final OpportuniteMapper opportuniteMapper;
    private final OpportuniteOutputMapper oppOutputMapper;
    private final WorkflowService workflowService;

    private final CurrentUser currentUser;
    private final KernelService kernelService;
    private final KernelInterface kernelInterface;
    private final OpportuniteInputMapper oppInputMapper;
    private final DemandeRepository demandeRepository;
    private final OffreRepository offreRepository;
    public OpportuniteServiceImpl(OpportuniteRepository opportuniteRepository, OpportuniteMapper opportuniteMapper,OpportuniteOutputMapper oppOutputMapper,
    WorkflowService workflowService, CurrentUser currentUser,
    KernelService kernelService,
    KernelInterface kernelInterface,OpportuniteInputMapper oppInputMapper,
    DemandeRepository demandeRepository,
    OffreRepository offreRepository

    ) {
        this.opportuniteRepository = opportuniteRepository;
        this.opportuniteMapper = opportuniteMapper;
        this.oppOutputMapper = oppOutputMapper;
        this.workflowService = workflowService;
        this.currentUser = currentUser;
        this.kernelService = kernelService;
        this.kernelInterface = kernelInterface;
        this.oppInputMapper = oppInputMapper;
        this.demandeRepository = demandeRepository;
        this.offreRepository = offreRepository;
    }

    @Override
    public OpportuniteDTO save(OpportuniteDTO opportuniteDTO) {
        log.debug("Request to save Opportunite : {}", opportuniteDTO);
        Opportunite opportunite = opportuniteMapper.toEntity(opportuniteDTO);
        opportunite = opportuniteRepository.save(opportunite);
        return opportuniteMapper.toDto(opportunite);
    }

    @Override
    public OpportuniteDTO update(OpportuniteDTO opportuniteDTO) {
        log.debug("Request to save Opportunite : {}", opportuniteDTO);
        Opportunite opportunite = opportuniteMapper.toEntity(opportuniteDTO);
        opportunite = opportuniteRepository.save(opportunite);
        return opportuniteMapper.toDto(opportunite);
    }

    @Override
    public Optional<OpportuniteDTO> partialUpdate(OpportuniteDTO opportuniteDTO) {
        log.debug("Request to partially update Opportunite : {}", opportuniteDTO);

        return opportuniteRepository
            .findById(opportuniteDTO.getId())
            .map(existingOpportunite -> {
                opportuniteMapper.partialUpdate(existingOpportunite, opportuniteDTO);

                return existingOpportunite;
            })
            .map(opportuniteRepository::save)
            .map(opportuniteMapper::toDto);
    }

    @Transactional
    public OpportuniteOutputDTO initProcessOpp(AclClass aclClass) throws Exception {

        // check existance of extracted acl class
        if (aclClass == null)
            throw new BadRequestAlertException(RCErrors.ERR_Msg_AclClass_null, RCErrors.Entity_requestCase, RCErrors.ERR_Key_AclClass_null);

        // initiate new object Courrier
        Opportunite opp = new Opportunite();
         opp.setCreateAt(ZonedDateTime.now());

        // persite the object
        opp = opportuniteRepository.save(opp);

        // map entity courrier to output DTO
        OpportuniteOutputDTO oppOutputDTO = oppOutputMapper.toDto(opp);

        oppOutputDTO.setClassId(aclClass.getId());

        oppOutputDTO.setClassName(aclClass.getClasse());

        oppOutputDTO.setLabelClass(aclClass.getLabel());

        oppOutputDTO.setSimpleClassName(aclClass.getSimpleName());

        // send variables to start new process instance
        BpmJob bpmJob = workflowService.startProcessInstanceWithoutEvent(currentUser.getEmployeSid(), aclClass.getFwProcess(), oppOutputDTO);

        List<String> authors = bpmJob.getAuthors();

        List<String> readers = bpmJob.getReaders();

        oppOutputDTO = (OpportuniteOutputDTO) bpmJob.getDataObject();

        opp = oppOutputMapper.toEntity(oppOutputDTO);

        opp.setWfProcessID(bpmJob.getProcessID());
        System.out.println("getProcessID"+bpmJob.getProcessID());
        opp.setActivityName(bpmJob.getActivityName());
        System.out.println("bpmJob.getActivityName()"+bpmJob.getActivityName());
        opp.setEndProcess(bpmJob.getEndProcess());
        System.out.println("bpmJob.getEndProcess()"+bpmJob.getEndProcess());
        opp.setAssignee(bpmJob.getAssignee() != null ? bpmJob.getAssignee() : null);
        System.out.println("bpmJob.getAssignee()"+bpmJob.getAssignee());
        //System.out.println("hkkkkkkkkkkkkkk"+kernelInterface.getSequenceNumberByName(new JSONObject(demande), aclClass.getSequenceNameFM()));
//        demande.setDemandeNumber(kernelInterface.getSequenceNumberByName(new JSONObject(demande), aclClass.getSequenceNameFM()));

        opp = saveDemande(opp, authors, readers, aclClass, true);
        System.out.println("opp object"+opp);
        return oppOutputMapper.toDto(opp);
    }
    public Opportunite saveDemande(Opportunite opp, List<String> authors, List<String> readers, AclClass aclClass, Boolean isCreated) {
        log.debug("Request to save Courrier : {}", opp);

        if (isCreated) {

            if (opp.getSecuriteLevel() == null) opp.setSecuriteLevel(aclClass.getSecuriteLevel());


            opp = setDefaultStateCourrier(opp, aclClass);

            opp = saveRequestCaseAndflush(opp);

            if (authors != null && readers != null && opp.getId() != null)
                kernelService.applySecurity(aclClass.getClasse(), opp.getId(), authors, readers, new ArrayList<>(), null, null, isCreated, false);
        } else {
            Opportunite oppRecent = opportuniteRepository.findById(opp.getId()).get();

            if (oppRecent.getWfProcessID() != null)
                opp.setWfProcessID(oppRecent.getWfProcessID());

            if (oppRecent.getOppNumber() != null)
                opp.setOppNumber(oppRecent.getOppNumber());

            if (!oppRecent.isExcludeFromView())
                opp.setExcludeFromView(oppRecent.isExcludeFromView());

            if (oppRecent.getActivityName() == null || (opp.getActivityName() != null && opp.getActivityName().equals("null")))
                opp.setActivityName(oppRecent.getActivityName());

            if (oppRecent.getSecuriteLevel() == null)
                opp.setSecuriteLevel(oppRecent.getSecuriteLevel());

            else if (!oppRecent.getSecuriteLevel().equals(opp.getSecuriteLevel()))
                try {
                    kernelService.adjustAttachmentSecurity(aclClass.getId(), oppRecent.getId(), opp.getSecuriteLevel());
                } catch (Exception e) {
                    log.error("error in adjustAttachmentSecurity " + e.getMessage());
                }

            try {
                Long numberOfAttachments = kernelInterface.countAttachements(opp.getId(), aclClass.getId());
                opp.setNumberOfattachments(numberOfAttachments);
            } catch (Exception e) {
                log.error(e.getMessage());
            }

            //compute zpl
            try {
                opp = setCurrentState(opp, aclClass);

                opp = saveDemande(opp);

                if (authors != null && readers != null && opp.getId() != null)
                    kernelService.applySecurity(aclClass.getClasse(), opp.getId(), authors, readers, new ArrayList<>(), null, null, isCreated, false);

            } catch (Exception e) {
                log.error(e.getMessage());
            }

        }

        return opp;
    }
    public Opportunite saveDemande(Opportunite opp) {
        Opportunite requestCase1 = opportuniteRepository.save(opp);

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
    public Opportunite setCurrentState(Opportunite opp, AclClass aclClass) {
        Optional<ObjectState> objectState = kernelService.getObjectStateCourrier(opp.getId(), aclClass.getClasse());
        if (objectState.isPresent()) {
            opp.setStatus(objectState.get().getCurrentState().getLabel());
        }
        return opp;
    }
    public Opportunite saveRequestCaseAndflush(Opportunite requestCase) {
        Opportunite opp1 = opportuniteRepository.saveAndFlush(requestCase);


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

        return opp1;
    }

    public Opportunite setDefaultStateCourrier(Opportunite opp, AclClass aclClass) {

        ObjectState objectState = new ObjectState();
        objectState.setBusinessClass(aclClass);
        objectState.setObjectId(opp.getId());
        if (aclClass.getDefaultState() == null)
            throw new BadRequestAlertException(
                    RCErrors.ERR_Msg_default_state_null,
                    RCErrors.Entity_requestCase,
                    RCErrors.ERR_Key_default_state_null);
        objectState.setCurrentState(aclClass.getDefaultState());
        kernelService.saveObjectState(objectState);
        // objectStateRepository.save(objectState);
        opp.setStatus(aclClass.getDefaultState().getLabel());
        return opp;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OpportuniteDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Opportunites");
        return opportuniteRepository.findAll(pageable).map(opportuniteMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OpportuniteDTO> findOne(Long id) {
        log.debug("Request to get Opportunite : {}", id);
        return opportuniteRepository.findById(id).map(opportuniteMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Opportunite : {}", id);
        opportuniteRepository.deleteById(id);
    }

    @Override
    public Opportunite saveAndAssignToDemande(Opportunite demandeDTO, Long demandeId) {
        return null;
    }

    @Override
    public Page<Opportunite> findAllOppotunite(Pageable pageable) {
        return null;
    }

    @Override
    public Opportunite getById(Long id) {

        log.debug("Request to get Demande : {}", id);
        return opportuniteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("opportunite with id " + id + " not found."));


    }
    public OpportuniteOutputDTO proceedGetDemandeId(Long id) throws IOException, TemplateException {
        log.debug("Request to get MmInbound : {}", id);

        OpportuniteOutputDTO oppOutputDTO = new OpportuniteOutputDTO();

        // check request case existance
        Optional<Opportunite> o = opportuniteRepository.findById(id);
        if (!o.isPresent())
            throw new BadRequestAlertException(
                    RCErrors.ERR_Key_requestCase_null,
                    RCErrors.Entity_requestCase,
                    RCErrors.ERR_Msg_requestCase_null);

        // check acl class existance
        AclClass aclClass = kernelInterface.getaclClassByClassName(Opportunite.class.getName());
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

            oppOutputDTO = oppOutputMapper.toDto(o.get());
            oppOutputDTO = this.setObjectInOutPutDTO(g, oppOutputDTO);
            oppOutputDTO.setUserPermission(permission);
            if (!permission.equals((Permission.WRITE.name()))) {
                WFDTO wfdtoWithOutDecision = oppOutputDTO.getWorkflow();
                if (oppOutputDTO.getWorkflow() != null) {
                    wfdtoWithOutDecision.setDecisionsWF(new ArrayList<>());
                    oppOutputDTO.setWorkflow(wfdtoWithOutDecision);
                    oppOutputDTO.setWfProcessName(oppOutputDTO.getWorkflow().getWfProcessName());
                }
            }

        }
        return oppOutputDTO;

    }
    public OpportuniteOutputDTO setObjectInOutPutDTO(ObjectsDTO g, OpportuniteOutputDTO requestCaseOutputDTO) throws IOException, TemplateException {
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


    @Override
    public OpportuniteDTO updateAndAssignTodemande(Long OpportuniteId, Long demandeId, OpportuniteDTO updatedDemandeDTO) {
        return null;
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
    public OpportuniteOutputDTO getbyideDTO(Long id) {

        OpportuniteOutputDTO result = null;
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
    @PersistenceContext(unitName = "externDSEmFactory")
    private EntityManager entityManager;
    @Transactional
    public OpportuniteOutputDTO submitProcessOpp(OpportuniteInputDTO oppInputDTO, AclClass aclClass) throws Exception {

        entityManager.clear();
        // extract object by id from data base
        Optional<Opportunite> oppOptional = opportuniteRepository.findById(oppInputDTO.getId());

        // extract courrier
        Opportunite requestCase = oppOptional.get();

        // check if the object exist in database
        if (!oppOptional.isPresent())
            throw new BadRequestAlertException(RCErrors.ERR_Msg_requestCase_null, RCErrors.Entity_requestCase, RCErrors.ERR_Key_requestCase_null);

        // extract permission of the authentifier from kernel
        String permission = kernelService.checkSecurity(aclClass.getSimpleName(), oppInputDTO.getId(), currentUser.getSid());

        // check if the authentifier has permission WRITE
        if (!permission.equals(Permission.WRITE.name()) && !permission.equals(Permission.INH_WRITE.name()))
            throw new BadRequestAlertException(RCErrors.ERR_Msg_not_authorized, RCErrors.Entity_requestCase, RCErrors.ERR_Key_not_authorized);

        // validate attributes courrier
        this.validateRequestCase(aclClass, oppInputDTO);

        // extract activity name from courrier
        String activityName = requestCase.getActivityName();

        // fusion the input object and the object from database
        oppInputMapper.partialUpdate(requestCase, oppInputDTO);

        // map object courrier to courrier by id DTO
        OpportuniteOutputDTO requestCaseOutputDTO = oppOutputMapper.toDto(requestCase);

        requestCaseOutputDTO.setClassId(aclClass.getId());

        requestCaseOutputDTO.setClassName(aclClass.getClasse());

        requestCaseOutputDTO.setLabelClass(aclClass.getLabel());

        requestCaseOutputDTO.setSimpleClassName(aclClass.getSimpleName());

        // initialize workflow information
        WFDTO workflow = new WFDTO();
        workflow.setWfProcessID(requestCase.getWfProcessID());
        workflow.setActivityName(requestCase.getActivityName());
        requestCaseOutputDTO.setWorkflow(workflow);

        BpmJob bpmJob = workflowService._nextTaskWithoutEvent(requestCase.getWfProcessID(), oppInputDTO.getDecision(), oppInputDTO.getWfComment(), requestCaseOutputDTO, aclClass);

        List<String> authors = bpmJob.getAuthors();

        List<String> readers = bpmJob.getReaders();

        requestCaseOutputDTO = (OpportuniteOutputDTO) bpmJob.getDataObject();

        requestCase = oppOutputMapper.toEntity(requestCaseOutputDTO);

        requestCase.setWfProcessID(bpmJob.getProcessID());

        requestCase.setActivityName(bpmJob.getActivityName());

        requestCase.setEndProcess(bpmJob.getEndProcess());

        requestCase.setAssignee(bpmJob.getAssignee() != null ? bpmJob.getAssignee() : null);

        requestCase = saveDemande(requestCase, authors, readers, aclClass, false);

        return oppOutputMapper.toDto(requestCase);

    }
    public Boolean validateRequestCase(AclClass aclClass, OpportuniteInputDTO oppInputDTO) {

        String nameRule = "save-" + aclClass.getSimpleName();

        RulesDTO rulesDTO = kernelService.rulesByName(nameRule);
        if (rulesDTO != null && rulesDTO.getSrcCode() != null) {
            List<Object> objectList = new ArrayList<>();
            objectList.add(oppInputDTO);
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

        if (oppInputDTO.getMsg() == null)
            return true;
        else
            throw new BadRequestAlertException(
                    oppInputDTO.getMsg(),
                    aclClass.getSimpleName(),
                    oppInputDTO.getMsg());


    }

    @Override
    public OpportuniteOutputDTO update(OpportuniteInputDTO demandeInputDTO, Long iddemande) {

        log.debug("Request to update Meeting : {}", demandeInputDTO);
        Demande demande = demandeRepository.findById(iddemande)
                .orElseThrow(() -> new IllegalArgumentException("Client with id " + iddemande + " not found."));
        Opportunite originalRequestCase = opportuniteRepository.findById(demandeInputDTO.getId()).get();
        originalRequestCase.setDemande(demande);
        oppInputMapper.partialUpdate(originalRequestCase, demandeInputDTO);

        originalRequestCase = opportuniteRepository.save(originalRequestCase);
       // opportuniteRepository.save(originalRequestCase);

        return oppOutputMapper.toDto(originalRequestCase);


    }

    @Override
    public List<Equipe> getEquipesAffectees(Long opportuniteId) {
        Opportunite opportunite = opportuniteRepository.findById(opportuniteId).orElse(null);
System.out.println("zazazazazazaaz"+opportunite);
System.out.println("getEquipe"+opportunite.getEquipes());
        if (opportunite == null) {
            throw new RuntimeException("Opportunite not found with id: " + opportuniteId);
        }

        return List.copyOf(opportunite.getEquipes());
    }

    @Override
    public Set<EtudeOpp> getEtude(Long id) {

        Opportunite opportunite = opportuniteRepository.findById(id).orElse(null);
        return (Set<EtudeOpp>) opportunite.getEtudeOpps();
    }

    @Override
    public Optional<OpportuniteDTO> affecterOpportuniteADemande(Long opportuniteId, Long demandeId) {
        Optional<Opportunite> opportuniteOptional = opportuniteRepository.findById(opportuniteId);
        Optional<Demande> demandeOptional = demandeRepository.findById(demandeId);

        if (opportuniteOptional.isPresent() && demandeOptional.isPresent()) {
            Opportunite opportunite = opportuniteOptional.get();
            Demande demande = demandeOptional.get();
            opportunite.setDemande(demande);
            Opportunite updatedOpportunite = opportuniteRepository.save(opportunite);
            return Optional.of(opportuniteMapper.toDto(updatedOpportunite));
        } else {
            return Optional.empty(); // Opportunité ou demande introuvable
        }

    }

    @Override
    public void setCreateOffreTrue(Long demandeId) {
        Opportunite opportunite = opportuniteRepository.findById(demandeId).get();
        if (opportunite != null) {
            opportunite.setCreateoffre(true);
            opportuniteRepository.save(opportunite);
        }
    }

    @Override
    public Optional<Opportunite> affecterOffre(Long opportuniteId, Long offreId) {
        Optional<Opportunite> optionalOpportunite = opportuniteRepository.findById(opportuniteId);
        Optional<Offre> optionalOffre = offreRepository.findById(offreId);

        optionalOpportunite.ifPresent(opportunite -> {
            optionalOffre.ifPresent(offre -> {
                opportunite.addOffre(offre);
                offre.setOpportunite(opportunite);
                opportuniteRepository.save(opportunite);
                offreRepository.save(offre);
            });
        });

        return optionalOpportunite;
    }


}
