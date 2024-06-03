package biz.picosoft.demo.service;


import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.DemandeInputDTO;
import biz.picosoft.demo.service.dto.DemandeOutputDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
     Demande saveAndAssignToClient(Demande demandeDTO, Long clientId);
     Page<Demande> findAllDemande(Pageable pageable);
     Demande getById(Long id);
     DemandeDTO updateAndAssignToClient(Long demandeId, Long clientId, DemandeDTO updatedDemandeDTO);
     Boolean checkRole(String profile, String roleName);
     DemandeOutputDTO getbyideDTO(Long id);
     DemandeOutputDTO update(DemandeInputDTO RequestCaseDTO,Long idclient);


    void setCreateOppTrue(Long demandeId);
    Demande affecterDomaines(Long demandeId, Set<Long> domaineIds);

    Page<DemandeOutputDTO> getValidationDemandes(Pageable pageable);

}
