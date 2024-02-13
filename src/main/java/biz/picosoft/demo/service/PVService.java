package biz.picosoft.demo.service;


import biz.picosoft.demo.service.dto.PVDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link biz.picosoft.demo.domain.PV}.
 */
public interface PVService {
    /**
     * Save a pV.
     *
     * @param pVDTO the entity to save.
     * @return the persisted entity.
     */
    PVDTO save(PVDTO pVDTO);

    /**
     * Updates a pV.
     *
     * @param pVDTO the entity to update.
     * @return the persisted entity.
     */
    PVDTO update(PVDTO pVDTO);

    /**
     * Partially updates a pV.
     *
     * @param pVDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PVDTO> partialUpdate(PVDTO pVDTO);

    /**
     * Get all the pVS.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PVDTO> findAll(Pageable pageable);

    /**
     * Get the "id" pV.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PVDTO> findOne(Long id);

    /**
     * Delete the "id" pV.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
