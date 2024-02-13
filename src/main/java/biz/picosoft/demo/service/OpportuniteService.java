package biz.picosoft.demo.service;


import biz.picosoft.demo.service.dto.OpportuniteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link biz.picosoft.demo.domain.Opportunite}.
 */
public interface OpportuniteService {
    /**
     * Save a opportunite.
     *
     * @param opportuniteDTO the entity to save.
     * @return the persisted entity.
     */
    OpportuniteDTO save(OpportuniteDTO opportuniteDTO);

    /**
     * Updates a opportunite.
     *
     * @param opportuniteDTO the entity to update.
     * @return the persisted entity.
     */
    OpportuniteDTO update(OpportuniteDTO opportuniteDTO);

    /**
     * Partially updates a opportunite.
     *
     * @param opportuniteDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<OpportuniteDTO> partialUpdate(OpportuniteDTO opportuniteDTO);

    /**
     * Get all the opportunites.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<OpportuniteDTO> findAll(Pageable pageable);

    /**
     * Get the "id" opportunite.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OpportuniteDTO> findOne(Long id);

    /**
     * Delete the "id" opportunite.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
