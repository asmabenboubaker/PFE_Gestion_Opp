package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.repository.DomaineRepository;
import biz.picosoft.demo.service.DomaineService;
import biz.picosoft.demo.service.dto.DomaineDTO;
import biz.picosoft.demo.service.mapper.DomaineMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Domaine}.
 */
@Service
@Transactional
public class DomaineServiceImpl implements DomaineService {

    private final Logger log = LoggerFactory.getLogger(DomaineServiceImpl.class);

    private final DomaineRepository domaineRepository;

    private final DomaineMapper domaineMapper;

    public DomaineServiceImpl(DomaineRepository domaineRepository, DomaineMapper domaineMapper) {
        this.domaineRepository = domaineRepository;
        this.domaineMapper = domaineMapper;
    }

    @Override
    public DomaineDTO save(DomaineDTO domaineDTO) {
        log.debug("Request to save Domaine : {}", domaineDTO);
        Domaine domaine = domaineMapper.toEntity(domaineDTO);
        domaine = domaineRepository.save(domaine);
        return domaineMapper.toDto(domaine);
    }

    @Override
    public DomaineDTO update(DomaineDTO domaineDTO) {
        log.debug("Request to save Domaine : {}", domaineDTO);
        Domaine domaine = domaineMapper.toEntity(domaineDTO);
        domaine = domaineRepository.save(domaine);
        return domaineMapper.toDto(domaine);
    }

    @Override
    public Optional<DomaineDTO> partialUpdate(DomaineDTO domaineDTO) {
        log.debug("Request to partially update Domaine : {}", domaineDTO);

        return domaineRepository
            .findById(domaineDTO.getId())
            .map(existingDomaine -> {
                domaineMapper.partialUpdate(existingDomaine, domaineDTO);

                return existingDomaine;
            })
            .map(domaineRepository::save)
            .map(domaineMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DomaineDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Domaines");
        return domaineRepository.findAll(pageable).map(domaineMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DomaineDTO> findOne(Long id) {
        log.debug("Request to get Domaine : {}", id);
        return domaineRepository.findById(id).map(domaineMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Domaine : {}", id);
        domaineRepository.deleteById(id);
    }
}
