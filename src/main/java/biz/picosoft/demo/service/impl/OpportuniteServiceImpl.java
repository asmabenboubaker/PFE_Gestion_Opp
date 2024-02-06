package biz.picosoft.demo.service.impl;


import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.repository.OpportuniteRepository;
import biz.picosoft.demo.service.OpportuniteService;
import biz.picosoft.demo.service.dto.OpportuniteDTO;
import biz.picosoft.demo.service.mapper.OpportuniteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Opportunite}.
 */
@Service
@Transactional
public class OpportuniteServiceImpl implements OpportuniteService {

    private final Logger log = LoggerFactory.getLogger(OpportuniteServiceImpl.class);

    private final OpportuniteRepository opportuniteRepository;

    private final OpportuniteMapper opportuniteMapper;

    public OpportuniteServiceImpl(OpportuniteRepository opportuniteRepository, OpportuniteMapper opportuniteMapper) {
        this.opportuniteRepository = opportuniteRepository;
        this.opportuniteMapper = opportuniteMapper;
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
}
