package biz.picosoft.demo.service;

import biz.picosoft.demo.domain.BonDeCommande;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.service.dto.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link biz.picosoft.demo.domain.BonDeCommande}.
 */
public interface BonDeCommandeService {
    /**
     * Save a bonDeCommande.
     *
     * @param bonDeCommandeDTO the entity to save.
     * @return the persisted entity.
     */
    BonDeCommandeDTO save(BonDeCommandeDTO bonDeCommandeDTO);

    /**
     * Updates a bonDeCommande.
     *
     * @param bonDeCommandeDTO the entity to update.
     * @return the persisted entity.
     */
    BonDeCommandeDTO update(BonDeCommandeDTO bonDeCommandeDTO);

    /**
     * Partially updates a bonDeCommande.
     *
     * @param bonDeCommandeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<BonDeCommandeDTO> partialUpdate(BonDeCommandeDTO bonDeCommandeDTO);

    /**
     * Get all the bonDeCommandes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BonDeCommandeDTO> findAll(Pageable pageable);

    /**
     * Get the "id" bonDeCommande.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BonDeCommandeDTO> findOne(Long id);

    /**
     * Delete the "id" bonDeCommande.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    Page<BonDeCommande> findAllDemande(Pageable pageable);
    BonDeCommande getById(Long id);
   // BonDeCommandeDTO updateAndAssignToClient(Long demandeId, Long clientId, DemandeDTO updatedDemandeDTO);
    Boolean checkRole(String profile, String roleName);
    BCOutputDTO getbyideDTO(Long id);
    BCOutputDTO update(BCInputDTO RequestCaseDTO,Long idclient);

}
