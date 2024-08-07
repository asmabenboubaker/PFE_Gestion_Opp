package biz.picosoft.demo.service;


import biz.picosoft.demo.service.dto.FactureDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link biz.picosoft.demo.domain.Facture}.
 */
public interface FactureService {
    /**
     * Save a facture.
     *
     * @param factureDTO the entity to save.
     * @return the persisted entity.
     */
    FactureDTO save(FactureDTO factureDTO);

    /**
     * Updates a facture.
     *
     * @param factureDTO the entity to update.
     * @return the persisted entity.
     */
    FactureDTO update(FactureDTO factureDTO);

    /**
     * Partially updates a facture.
     *
     * @param factureDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<FactureDTO> partialUpdate(FactureDTO factureDTO);

    /**
     * Get all the factures.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<FactureDTO> findAll(Pageable pageable);

    /**
     * Get the "id" facture.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FactureDTO> findOne(Long id);

    /**
     * Delete the "id" facture.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
