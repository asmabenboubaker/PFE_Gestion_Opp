package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.Workflow.domain.BpmJob;
import biz.picosoft.demo.Workflow.service.WorkflowService;
import biz.picosoft.demo.client.kernel.intercomm.KernelInterface;
import biz.picosoft.demo.client.kernel.intercomm.KernelService;
import biz.picosoft.demo.client.kernel.model.acl.AclClass;
import biz.picosoft.demo.client.kernel.model.global.CurrentUser;
import biz.picosoft.demo.client.kernel.model.objects.ObjectState;
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
import biz.picosoft.demo.service.dto.DemandeOutputDTO;
import biz.picosoft.demo.service.mapper.DemandeMapper;

import biz.picosoft.demo.service.mapper.DemandeOutputMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private DemandeOutputMapper demandeOutputMapper;

    private WorkflowService workflowService;

    private CurrentUser currentUser;

    public DemandeServiceImpl(DemandeRepository demandeRepository, DemandeMapper demandeMapper,ClientRepository clientRepository,DemandeOutputMapper demandeOutputMapper,
                              WorkflowService workflowService,CurrentUser currentUser,KernelService kernelService,KernelInterface kernelInterface) {
        this.demandeRepository = demandeRepository;
        this.demandeMapper = demandeMapper;
        this.clientRepository=clientRepository;
        this.workflowService=workflowService;
        this.demandeOutputMapper=demandeOutputMapper;
        this.currentUser=currentUser;
        this.kernelInterface=kernelInterface;
        this.kernelService=kernelService;

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

    // process methode


    @Transactional
    public DemandeOutputDTO initProcessDemande(AclClass aclClass) throws Exception {

        // check existance of extracted acl class
        if (aclClass == null)
            throw new BadRequestAlertException(RCErrors.ERR_Msg_AclClass_null, RCErrors.Entity_requestCase, RCErrors.ERR_Key_AclClass_null);

        // initiate new object Courrier
        Demande demande = new Demande();

        //demande.setDateDeCreation(LocalDate.now());

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
        //demande.setDemandeNumber(kernelInterface.getSequenceNumberByName(new JSONObject(demande), aclClass.getSequenceNameFM()));

        demande = saveDemande(demande, authors, readers, aclClass, true);
 System.out.println("demande object"+demande);
        return demandeOutputMapper.toDto(demande);
    }
    public Demande saveDemande(Demande requestCase) {
        Demande requestCase1 = demandeRepository.save(requestCase);

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

}
