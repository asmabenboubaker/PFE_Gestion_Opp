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
import biz.picosoft.demo.controller.errors.RCErrors;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.repository.OffreRepository;
import biz.picosoft.demo.service.OffreService;
import biz.picosoft.demo.service.dto.DemandeOutputDTO;
import biz.picosoft.demo.service.dto.OffreDTO;
import biz.picosoft.demo.service.dto.OffreOutputDTO;
import biz.picosoft.demo.service.mapper.DemandeOutputMapper;
import biz.picosoft.demo.service.mapper.OffreMapper;

import biz.picosoft.demo.service.mapper.OffreOutputMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Offre}.
 */
@Service
@Transactional
public class OffreServiceImpl implements OffreService {

    private final Logger log = LoggerFactory.getLogger(OffreServiceImpl.class);

    private final OffreRepository offreRepository;

    private final OffreMapper offreMapper;
    //add workflowService
    private final WorkflowService workflowService;
    private final OffreOutputMapper offreOutputMapper;
    private final CurrentUser currentUser;
    private final KernelService kernelService;
    private final KernelInterface kernelInterface;

    public OffreServiceImpl(OffreRepository offreRepository, OffreMapper offreMapper, OffreOutputMapper offreOutputMapper, WorkflowService workflowService,
                            CurrentUser currentUser,
                            KernelService kernelService,
                            KernelInterface kernelInterface

    ) {
        this.offreRepository = offreRepository;
        this.offreMapper = offreMapper;
        this.offreOutputMapper = offreOutputMapper;
        this.workflowService = workflowService;
        this.currentUser = currentUser;
        this.kernelService = kernelService;
        this.kernelInterface = kernelInterface;

    }

    @Override
    public OffreDTO save(OffreDTO offreDTO) {
        log.debug("Request to save Offre : {}", offreDTO);
        Offre offre = offreMapper.toEntity(offreDTO);
        offre = offreRepository.save(offre);
        return offreMapper.toDto(offre);
    }

    @Override
    public OffreDTO update(OffreDTO offreDTO) {
        log.debug("Request to save Offre : {}", offreDTO);
        Offre offre = offreMapper.toEntity(offreDTO);
        offre = offreRepository.save(offre);
        return offreMapper.toDto(offre);
    }

    @Override
    public Optional<OffreDTO> partialUpdate(OffreDTO offreDTO) {
        log.debug("Request to partially update Offre : {}", offreDTO);

        return offreRepository
            .findById(offreDTO.getId())
            .map(existingOffre -> {
                offreMapper.partialUpdate(existingOffre, offreDTO);

                return existingOffre;
            })
            .map(offreRepository::save)
            .map(offreMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OffreDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Offres");
        return offreRepository.findAll(pageable).map(offreMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OffreDTO> findOne(Long id) {
        log.debug("Request to get Offre : {}", id);
        return offreRepository.findById(id).map(offreMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Offre : {}", id);
        offreRepository.deleteById(id);
    }

    // start process
    @Transactional
    public OffreOutputDTO initProcessOffre(AclClass aclClass) throws Exception {

        // check existance of extracted acl class
        if (aclClass == null)
            throw new BadRequestAlertException(RCErrors.ERR_Msg_AclClass_null, RCErrors.Entity_requestCase, RCErrors.ERR_Key_AclClass_null);

        // initiate new object Courrier
        Offre offre = new Offre();

        offre.setDateOffre(ZonedDateTime.now());

        // persite the object
        offre = offreRepository.save(offre);

        // map entity courrier to output DTO
        OffreOutputDTO offreOutputDTO = offreOutputMapper.toDto(offre);

        offreOutputDTO.setClassId(aclClass.getId());

        offreOutputDTO.setClassName(aclClass.getClasse());

        offreOutputDTO.setLabelClass(aclClass.getLabel());

        offreOutputDTO.setSimpleClassName(aclClass.getSimpleName());

        // send variables to start new process instance
        BpmJob bpmJob = workflowService.startProcessInstanceWithoutEvent(currentUser.getEmployeSid(), aclClass.getFwProcess(), offreOutputDTO);

        List<String> authors = bpmJob.getAuthors();

        List<String> readers = bpmJob.getReaders();

        offreOutputDTO = (OffreOutputDTO) bpmJob.getDataObject();

        offre = offreOutputMapper.toEntity(offreOutputDTO);

        offre.setWfProcessID(bpmJob.getProcessID());
        System.out.println("getProcessID"+bpmJob.getProcessID());
        offre.setActivityName(bpmJob.getActivityName());
        System.out.println("bpmJob.getActivityName()"+bpmJob.getActivityName());
        offre.setEndProcess(bpmJob.getEndProcess());
        System.out.println("bpmJob.getEndProcess()"+bpmJob.getEndProcess());
        offre.setAssignee(bpmJob.getAssignee() != null ? bpmJob.getAssignee() : null);
        System.out.println("bpmJob.getAssignee()"+bpmJob.getAssignee());
        //System.out.println("hkkkkkkkkkkkkkk"+kernelInterface.getSequenceNumberByName(new JSONObject(demande), aclClass.getSequenceNameFM()));
//        demande.setDemandeNumber(kernelInterface.getSequenceNumberByName(new JSONObject(demande), aclClass.getSequenceNameFM()));

        offre = saveOffre(offre, authors, readers, aclClass, true);
        System.out.println("demande object"+offre);
        return offreOutputMapper.toDto(offre);
    }

    public Offre saveOffre(Offre offre, List<String> authors, List<String> readers, AclClass aclClass, Boolean isCreated) {
        log.debug("Request to save Courrier : {}", offre);

        if (isCreated) {

            if (offre.getSecuriteLevel() == null) offre.setSecuriteLevel(aclClass.getSecuriteLevel());


            offre = setDefaultStateCourrier(offre, aclClass);

            offre = saveRequestCaseAndflush(offre);

            if (authors != null && readers != null && offre.getId() != null)
                kernelService.applySecurity(aclClass.getClasse(), offre.getId(), authors, readers, new ArrayList<>(), null, null, isCreated, false);
        } else {
            Offre offreRecent = offreRepository.findById(offre.getId()).get();

            if (offreRecent.getWfProcessID() != null)
                offre.setWfProcessID(offreRecent.getWfProcessID());

            if (offreRecent.getOffreNumber() != null)
                offre.setOffreNumber(offreRecent.getOffreNumber());

            if (!offreRecent.getExcludeFromView())
                offre.setExcludeFromView(offreRecent.getExcludeFromView());

            if (offreRecent.getActivityName() == null || (offre.getActivityName() != null && offre.getActivityName().equals("null")))
                offre.setActivityName(offreRecent.getActivityName());

            if (offreRecent.getSecuriteLevel() == null)
                offre.setSecuriteLevel(offreRecent.getSecuriteLevel());

            else if (!offreRecent.getSecuriteLevel().equals(offre.getSecuriteLevel()))
                try {
                    kernelService.adjustAttachmentSecurity(aclClass.getId(), offreRecent.getId(), offre.getSecuriteLevel());
                } catch (Exception e) {
                    log.error("error in adjustAttachmentSecurity " + e.getMessage());
                }

            try {
                Long numberOfAttachments = kernelInterface.countAttachements(offre.getId(), aclClass.getId());
                offre.setNumberOfattachments(numberOfAttachments);
            } catch (Exception e) {
                log.error(e.getMessage());
            }

            //compute zpl
            try {
                offre = setCurrentState(offre, aclClass);

                offre = saveOffre(offre);

                if (authors != null && readers != null && offre.getId() != null)
                    kernelService.applySecurity(aclClass.getClasse(), offre.getId(), authors, readers, new ArrayList<>(), null, null, isCreated, false);

            } catch (Exception e) {
                log.error(e.getMessage());
            }

        }

        return offre;
    }
    public Offre setCurrentState(Offre offre, AclClass aclClass) {
        Optional<ObjectState> objectState = kernelService.getObjectStateCourrier(offre.getId(), aclClass.getClasse());
        if (objectState.isPresent()) {
            offre.setStatus(objectState.get().getCurrentState().getLabel());
        }
        return offre;
    }
    public Offre saveRequestCaseAndflush(Offre requestCase) {
        Offre offre1 = offreRepository.saveAndFlush(requestCase);


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

        return offre1;
    }

    public Offre saveOffre(Offre offre) {
        Offre requestCase1 = offreRepository.save(offre);


        return requestCase1;
    }
    public Offre setDefaultStateCourrier(Offre offre, AclClass aclClass) {

        ObjectState objectState = new ObjectState();
        objectState.setBusinessClass(aclClass);
        objectState.setObjectId(offre.getId());
        if (aclClass.getDefaultState() == null)
            throw new BadRequestAlertException(
                    RCErrors.ERR_Msg_default_state_null,
                    RCErrors.Entity_requestCase,
                    RCErrors.ERR_Key_default_state_null);
        objectState.setCurrentState(aclClass.getDefaultState());
        kernelService.saveObjectState(objectState);
        // objectStateRepository.save(objectState);
        offre.setStatus(aclClass.getDefaultState().getLabel());
        return offre;
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

}
