package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.Workflow.domain.BpmJob;
import biz.picosoft.demo.Workflow.service.WorkflowService;
import biz.picosoft.demo.client.kernel.intercomm.KernelInterface;
import biz.picosoft.demo.client.kernel.intercomm.KernelService;
import biz.picosoft.demo.client.kernel.model.acl.AclClass;
import biz.picosoft.demo.client.kernel.model.global.CurrentUser;
import biz.picosoft.demo.client.kernel.model.objects.ObjectState;
import biz.picosoft.demo.controller.errors.BadRequestAlertException;
import biz.picosoft.demo.controller.errors.RCErrors;
import biz.picosoft.demo.domain.BonDeCommande;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.repository.BonDeCommandeRepository;
import biz.picosoft.demo.service.BonDeCommandeService;
import biz.picosoft.demo.service.dto.BCInputDTO;
import biz.picosoft.demo.service.dto.BCOutputDTO;
import biz.picosoft.demo.service.dto.BonDeCommandeDTO;
import biz.picosoft.demo.service.dto.DemandeOutputDTO;
import biz.picosoft.demo.service.mapper.BCOutputMapper;
import biz.picosoft.demo.service.mapper.BonDeCommandeMapper;

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
 * Service Implementation for managing {@link BonDeCommande}.
 */
@Service
@Transactional
public class BonDeCommandeServiceImpl implements BonDeCommandeService {

    private final Logger log = LoggerFactory.getLogger(BonDeCommandeServiceImpl.class);

    private final BonDeCommandeRepository bonDeCommandeRepository;

    private final BonDeCommandeMapper bonDeCommandeMapper;

    private final BCOutputMapper bcOutputMapper;
    private final WorkflowService workflowService;
    private final CurrentUser currentUser;
    //add kernelService
    private final KernelService kernelService;
    private final KernelInterface  kernelInterface;

    public BonDeCommandeServiceImpl(BonDeCommandeRepository bonDeCommandeRepository, BonDeCommandeMapper bonDeCommandeMapper, BCOutputMapper bcOutputMapper, WorkflowService workflowService,
                                    CurrentUser currentUser, KernelService kernelService, KernelInterface kernelInterface) {
        this.bonDeCommandeRepository = bonDeCommandeRepository;
        this.bonDeCommandeMapper = bonDeCommandeMapper;
        this.bcOutputMapper = bcOutputMapper;
        this.workflowService = workflowService;
        this.currentUser = currentUser;
        this.kernelService = kernelService;
        this.kernelInterface = kernelInterface;
    }

    @Override
    public BonDeCommandeDTO save(BonDeCommandeDTO bonDeCommandeDTO) {
        log.debug("Request to save BonDeCommande : {}", bonDeCommandeDTO);
        BonDeCommande bonDeCommande = bonDeCommandeMapper.toEntity(bonDeCommandeDTO);
        bonDeCommande = bonDeCommandeRepository.save(bonDeCommande);
        return bonDeCommandeMapper.toDto(bonDeCommande);
    }

    @Override
    public BonDeCommandeDTO update(BonDeCommandeDTO bonDeCommandeDTO) {
        log.debug("Request to save BonDeCommande : {}", bonDeCommandeDTO);
        BonDeCommande bonDeCommande = bonDeCommandeMapper.toEntity(bonDeCommandeDTO);
        bonDeCommande = bonDeCommandeRepository.save(bonDeCommande);
        return bonDeCommandeMapper.toDto(bonDeCommande);
    }

    @Override
    public Optional<BonDeCommandeDTO> partialUpdate(BonDeCommandeDTO bonDeCommandeDTO) {
        log.debug("Request to partially update BonDeCommande : {}", bonDeCommandeDTO);

        return bonDeCommandeRepository
            .findById(bonDeCommandeDTO.getId())
            .map(existingBonDeCommande -> {
                bonDeCommandeMapper.partialUpdate(existingBonDeCommande, bonDeCommandeDTO);

                return existingBonDeCommande;
            })
            .map(bonDeCommandeRepository::save)
            .map(bonDeCommandeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BonDeCommandeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BonDeCommandes");
        return bonDeCommandeRepository.findAll(pageable).map(bonDeCommandeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BonDeCommandeDTO> findOne(Long id) {
        log.debug("Request to get BonDeCommande : {}", id);
        return bonDeCommandeRepository.findById(id).map(bonDeCommandeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete BonDeCommande : {}", id);
        bonDeCommandeRepository.deleteById(id);
    }

    @Override
    public Page<BonDeCommande> findAllDemande(Pageable pageable) {
        return null;
    }

    @Override
    public BonDeCommande getById(Long id) {
        return null;
    }

    @Override
    public Boolean checkRole(String profile, String roleName) {
        return null;
    }

    @Override
    public BCOutputDTO getbyideDTO(Long id) {
        return null;
    }

    @Override
    public BCOutputDTO update(BCInputDTO RequestCaseDTO, Long idclient) {
        return null;
    }

//workflow
    @Transactional
    public BCOutputDTO initProcessBC(AclClass aclClass) throws Exception {

        // check existance of extracted acl class
        if (aclClass == null)
            throw new BadRequestAlertException(RCErrors.ERR_Msg_AclClass_null, RCErrors.Entity_requestCase, RCErrors.ERR_Key_AclClass_null);

        // initiate new object Courrier
        BonDeCommande bc = new BonDeCommande();

        bc.setDateCommande(ZonedDateTime.now());

        // persite the object
        bc = bonDeCommandeRepository.save(bc);

        // map entity courrier to output DTO
        BCOutputDTO bcOutputDTO = bcOutputMapper.toDto(bc);

        bcOutputDTO.setClassId(aclClass.getId());

        bcOutputDTO.setClassName(aclClass.getClasse());

        bcOutputDTO.setLabelClass(aclClass.getLabel());

        bcOutputDTO.setSimpleClassName(aclClass.getSimpleName());

        // send variables to start new process instance
        BpmJob bpmJob = workflowService.startProcessInstanceWithoutEvent(currentUser.getEmployeSid(), aclClass.getFwProcess(), bcOutputDTO);

        List<String> authors = bpmJob.getAuthors();

        List<String> readers = bpmJob.getReaders();

        bcOutputDTO = (BCOutputDTO) bpmJob.getDataObject();

        bc = bcOutputMapper.toEntity(bcOutputDTO);

        bc.setWfProcessID(bpmJob.getProcessID());
        System.out.println("getProcessID"+bpmJob.getProcessID());
        bc.setActivityName(bpmJob.getActivityName());
        System.out.println("bpmJob.getActivityName()"+bpmJob.getActivityName());
        bc.setEndProcess(bpmJob.getEndProcess());
        System.out.println("bpmJob.getEndProcess()"+bpmJob.getEndProcess());
        bc.setAssignee(bpmJob.getAssignee() != null ? bpmJob.getAssignee() : null);
        System.out.println("bpmJob.getAssignee()"+bpmJob.getAssignee());
        //System.out.println("hkkkkkkkkkkkkkk"+kernelInterface.getSequenceNumberByName(new JSONObject(demande), aclClass.getSequenceNameFM()));
//        demande.setDemandeNumber(kernelInterface.getSequenceNumberByName(new JSONObject(demande), aclClass.getSequenceNameFM()));

        bc = saveBC(bc, authors, readers, aclClass, true);
        System.out.println("demande object"+bc);
        return bcOutputMapper.toDto(bc);
    }

    public BonDeCommande saveBC(BonDeCommande bc) {
        BonDeCommande requestCase1 = bonDeCommandeRepository.save(bc);
        return requestCase1;
    }
    public BonDeCommande saveBC(BonDeCommande bc, List<String> authors, List<String> readers, AclClass aclClass, Boolean isCreated) {
        log.debug("Request to save Courrier : {}", bc);

        if (isCreated) {

            if (bc.getSecuriteLevel() == null) bc.setSecuriteLevel(aclClass.getSecuriteLevel());


            bc = setDefaultStateCourrier(bc, aclClass);

            bc = saveRequestCaseAndflush(bc);

            if (authors != null && readers != null && bc.getId() != null)
                kernelService.applySecurity(aclClass.getClasse(), bc.getId(), authors, readers, new ArrayList<>(), null, null, isCreated, false);
        } else {
            BonDeCommande bcRecent = bonDeCommandeRepository.findById(bc.getId()).get();

            if (bcRecent.getWfProcessID() != null)
                bc.setWfProcessID(bcRecent.getWfProcessID());

            if (bcRecent.getDemandeNumber() != null)
                bc.setDemandeNumber(bcRecent.getDemandeNumber());

            if (!bcRecent.isExcludeFromView())
                bc.setExcludeFromView(bcRecent.isExcludeFromView());

            if (bcRecent.getActivityName() == null || (bcRecent.getActivityName() != null && bcRecent.getActivityName().equals("null")))
                bc.setActivityName(bcRecent.getActivityName());

            if (bcRecent.getSecuriteLevel() == null)
                bc.setSecuriteLevel(bcRecent.getSecuriteLevel());

            else if (!bcRecent.getSecuriteLevel().equals(bc.getSecuriteLevel()))
                try {
                    kernelService.adjustAttachmentSecurity(aclClass.getId(), bcRecent.getId(), bc.getSecuriteLevel());
                } catch (Exception e) {
                    log.error("error in adjustAttachmentSecurity " + e.getMessage());
                }

            try {
                Long numberOfAttachments = kernelInterface.countAttachements(bc.getId(), aclClass.getId());
                bc.setNumberOfattachments(numberOfAttachments);
            } catch (Exception e) {
                log.error(e.getMessage());
            }

            //compute zpl
            try {
                bc = setCurrentState(bc, aclClass);

                bc = saveBC(bc);

                if (authors != null && readers != null && bc.getId() != null)
                    kernelService.applySecurity(aclClass.getClasse(), bc.getId(), authors, readers, new ArrayList<>(), null, null, isCreated, false);

            } catch (Exception e) {
                log.error(e.getMessage());
            }

        }

        return bc;
    }

    public BonDeCommande setDefaultStateCourrier(BonDeCommande bc, AclClass aclClass) {

        ObjectState objectState = new ObjectState();
        objectState.setBusinessClass(aclClass);
        objectState.setObjectId(bc.getId());
        if (aclClass.getDefaultState() == null)
            throw new BadRequestAlertException(
                    RCErrors.ERR_Msg_default_state_null,
                    RCErrors.Entity_requestCase,
                    RCErrors.ERR_Key_default_state_null);
        objectState.setCurrentState(aclClass.getDefaultState());
        kernelService.saveObjectState(objectState);
        // objectStateRepository.save(objectState);
        bc.setStatus(aclClass.getDefaultState().getLabel());
        return bc;
    }

    public BonDeCommande saveRequestCaseAndflush(BonDeCommande requestCase) {
        BonDeCommande demande1 = bonDeCommandeRepository.saveAndFlush(requestCase);


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
    public BonDeCommande setCurrentState(BonDeCommande bc, AclClass aclClass) {
        Optional<ObjectState> objectState = kernelService.getObjectStateCourrier(bc.getId(), aclClass.getClasse());
        if (objectState.isPresent()) {
            bc.setStatus(objectState.get().getCurrentState().getLabel());
        }
        return bc;
    }

}
