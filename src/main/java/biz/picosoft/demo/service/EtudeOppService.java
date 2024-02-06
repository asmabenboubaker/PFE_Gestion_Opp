package biz.picosoft.demo.service;

import biz.picosoft.demo.service.dto.EtudeOppDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link biz.picosoft.demo.domain.EtudeOpp}.
 */
public interface EtudeOppService {
    /**
     * Save a etudeOpp.
     *
     * @param etudeOppDTO the entity to save.
     * @return the persisted entity.
     */
    EtudeOppDTO save(EtudeOppDTO etudeOppDTO);

    /**
     * Updates a etudeOpp.
     *
     * @param etudeOppDTO the entity to update.
     * @return the persisted entity.
     */
    EtudeOppDTO update(EtudeOppDTO etudeOppDTO);

    /**
     * Partially updates a etudeOpp.
     *
     * @param etudeOppDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<EtudeOppDTO> partialUpdate(EtudeOppDTO etudeOppDTO);

    /**
     * Get all the etudeOpps.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<EtudeOppDTO> findAll(Pageable pageable);

    /**
     * Get the "id" etudeOpp.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EtudeOppDTO> findOne(Long id);

    /**
     * Delete the "id" etudeOpp.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
