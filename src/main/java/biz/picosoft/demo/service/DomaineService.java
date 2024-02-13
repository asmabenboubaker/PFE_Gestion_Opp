package biz.picosoft.demo.service;


import biz.picosoft.demo.service.dto.DomaineDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link biz.picosoft.demo.domain.Domaine}.
 */
public interface DomaineService {
    /**
     * Save a domaine.
     *
     * @param domaineDTO the entity to save.
     * @return the persisted entity.
     */
    DomaineDTO save(DomaineDTO domaineDTO);

    /**
     * Updates a domaine.
     *
     * @param domaineDTO the entity to update.
     * @return the persisted entity.
     */
    DomaineDTO update(DomaineDTO domaineDTO);

    /**
     * Partially updates a domaine.
     *
     * @param domaineDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<DomaineDTO> partialUpdate(DomaineDTO domaineDTO);

    /**
     * Get all the domaines.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DomaineDTO> findAll(Pageable pageable);

    /**
     * Get the "id" domaine.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DomaineDTO> findOne(Long id);

    /**
     * Delete the "id" domaine.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
