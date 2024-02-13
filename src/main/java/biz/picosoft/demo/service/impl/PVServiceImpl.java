package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.domain.PV;
import biz.picosoft.demo.repository.PVRepository;
import biz.picosoft.demo.service.PVService;
import biz.picosoft.demo.service.dto.PVDTO;
import biz.picosoft.demo.service.mapper.PVMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PV}.
 */
@Service
@Transactional
public class PVServiceImpl implements PVService {

    private final Logger log = LoggerFactory.getLogger(PVServiceImpl.class);

    private final PVRepository pVRepository;

    private final PVMapper pVMapper;

    public PVServiceImpl(PVRepository pVRepository, PVMapper pVMapper) {
        this.pVRepository = pVRepository;
        this.pVMapper = pVMapper;
    }

    @Override
    public PVDTO save(PVDTO pVDTO) {
        log.debug("Request to save PV : {}", pVDTO);
        PV pV = pVMapper.toEntity(pVDTO);
        pV = pVRepository.save(pV);
        return pVMapper.toDto(pV);
    }

    @Override
    public PVDTO update(PVDTO pVDTO) {
        log.debug("Request to save PV : {}", pVDTO);
        PV pV = pVMapper.toEntity(pVDTO);
        pV = pVRepository.save(pV);
        return pVMapper.toDto(pV);
    }

    @Override
    public Optional<PVDTO> partialUpdate(PVDTO pVDTO) {
        log.debug("Request to partially update PV : {}", pVDTO);

        return pVRepository
            .findById(pVDTO.getId())
            .map(existingPV -> {
                pVMapper.partialUpdate(existingPV, pVDTO);

                return existingPV;
            })
            .map(pVRepository::save)
            .map(pVMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PVDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PVS");
        return pVRepository.findAll(pageable).map(pVMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PVDTO> findOne(Long id) {
        log.debug("Request to get PV : {}", id);
        return pVRepository.findById(id).map(pVMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PV : {}", id);
        pVRepository.deleteById(id);
    }
}
