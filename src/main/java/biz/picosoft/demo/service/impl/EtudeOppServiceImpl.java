package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.repository.EtudeOppRepository;
import biz.picosoft.demo.repository.OpportuniteRepository;
import biz.picosoft.demo.service.EtudeOppService;
import biz.picosoft.demo.service.dto.EtudeOppDTO;
import biz.picosoft.demo.service.mapper.EtudeOppMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link EtudeOpp}.
 */
@Service
@Transactional
public class EtudeOppServiceImpl implements EtudeOppService {

    private final Logger log = LoggerFactory.getLogger(EtudeOppServiceImpl.class);

    private final EtudeOppRepository etudeOppRepository;

    private final EtudeOppMapper etudeOppMapper;
    private final OpportuniteRepository opportuniteRepository;

    public EtudeOppServiceImpl(EtudeOppRepository etudeOppRepository, EtudeOppMapper etudeOppMapper, OpportuniteRepository opportuniteRepository) {
        this.etudeOppRepository = etudeOppRepository;
        this.etudeOppMapper = etudeOppMapper;
        this.opportuniteRepository = opportuniteRepository;
    }

    @Override
    public EtudeOppDTO save(EtudeOppDTO etudeOppDTO) {
        log.debug("Request to save EtudeOpp : {}", etudeOppDTO);
        EtudeOpp etudeOpp = etudeOppMapper.toEntity(etudeOppDTO);
        etudeOpp = etudeOppRepository.save(etudeOpp);
        return etudeOppMapper.toDto(etudeOpp);
    }

    @Override
    public EtudeOppDTO update(EtudeOppDTO etudeOppDTO) {
        log.debug("Request to save EtudeOpp : {}", etudeOppDTO);
        EtudeOpp etudeOpp = etudeOppMapper.toEntity(etudeOppDTO);
        etudeOpp = etudeOppRepository.save(etudeOpp);
        return etudeOppMapper.toDto(etudeOpp);
    }

    @Override
    public Optional<EtudeOppDTO> partialUpdate(EtudeOppDTO etudeOppDTO) {
        log.debug("Request to partially update EtudeOpp : {}", etudeOppDTO);

        return etudeOppRepository
            .findById(etudeOppDTO.getId())
            .map(existingEtudeOpp -> {
                etudeOppMapper.partialUpdate(existingEtudeOpp, etudeOppDTO);

                return existingEtudeOpp;
            })
            .map(etudeOppRepository::save)
            .map(etudeOppMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EtudeOppDTO> findAll(Pageable pageable) {
        log.debug("Request to get all EtudeOpps");
        return etudeOppRepository.findAll(pageable).map(etudeOppMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EtudeOppDTO> findOne(Long id) {
        log.debug("Request to get EtudeOpp : {}", id);
        return etudeOppRepository.findById(id).map(etudeOppMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete EtudeOpp : {}", id);
        etudeOppRepository.deleteById(id);
    }

    @Override
    public EtudeOppDTO saveEtudeOppWithAffectation(EtudeOppDTO etudeOppDTO, Long idOpportunite) {
        // ajouter EtudeOpp acec affectation opportunité
        // find by id opp
        Opportunite opp=opportuniteRepository.findById(idOpportunite).get();

        // set etudeOpp to opp
        EtudeOpp etudeOpp = etudeOppMapper.toEntity(etudeOppDTO);
        etudeOpp.setOpportunite(opp);
        etudeOpp = etudeOppRepository.save(etudeOpp);
        return etudeOppMapper.toDto(etudeOpp);

    }

    @Override
    public List<EtudeOpp> findAllByOpportuniteId(Long opportuniteId) {
        return etudeOppRepository.findAllByOpportuniteId(opportuniteId);
    }
}
