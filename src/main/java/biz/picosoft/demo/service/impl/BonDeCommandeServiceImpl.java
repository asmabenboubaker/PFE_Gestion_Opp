package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.domain.BonDeCommande;
import biz.picosoft.demo.repository.BonDeCommandeRepository;
import biz.picosoft.demo.service.BonDeCommandeService;
import biz.picosoft.demo.service.dto.BonDeCommandeDTO;
import biz.picosoft.demo.service.mapper.BonDeCommandeMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public BonDeCommandeServiceImpl(BonDeCommandeRepository bonDeCommandeRepository, BonDeCommandeMapper bonDeCommandeMapper) {
        this.bonDeCommandeRepository = bonDeCommandeRepository;
        this.bonDeCommandeMapper = bonDeCommandeMapper;
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
}
