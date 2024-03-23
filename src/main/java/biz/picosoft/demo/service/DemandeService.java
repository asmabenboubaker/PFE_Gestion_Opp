package biz.picosoft.demo.service;


import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.service.dto.DemandeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link  biz.picosoft.demo.domain.Demande}.
 */
public interface DemandeService {
    /**
     * Save a demande.
     *
     * @param demandeDTO the entity to save.
     * @return the persisted entity.
     */
    DemandeDTO save(DemandeDTO demandeDTO);

    /**
     * Updates a demande.
     *
     * @param demandeDTO the entity to update.
     * @return the persisted entity.
     */
    DemandeDTO update(DemandeDTO demandeDTO);

    /**
     * Partially updates a demande.
     *
     * @param demandeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<DemandeDTO> partialUpdate(DemandeDTO demandeDTO);

    /**
     * Get all the demandes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DemandeDTO> findAll(Pageable pageable);

    /**
     * Get all the demandes with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DemandeDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" demande.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DemandeDTO> findOne(Long id);

    /**
     * Delete the "id" demande.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
     Demande saveAndAssignToClient(DemandeDTO demandeDTO, Long clientId);
     Page<Demande> findAllDemande(Pageable pageable);
     Demande getById(Long id);
     Demande updateAndAssignToClient(Long demandeId, Long clientId, DemandeDTO updatedDemandeDTO);
}
