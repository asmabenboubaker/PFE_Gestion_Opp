package biz.picosoft.demo.service;


import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    Opportunite saveAndAssignToDemande(Opportunite demandeDTO, Long demandeId);
    Page<Opportunite> findAllOppotunite(Pageable pageable);
    Opportunite getById(Long id);
    OpportuniteDTO updateAndAssignTodemande(Long OpportuniteId, Long demandeId, OpportuniteDTO updatedDemandeDTO);
    Boolean checkRole(String profile, String roleName);
    OpportuniteOutputDTO getbyideDTO(Long id);
    OpportuniteOutputDTO update(OpportuniteInputDTO demandeInputDTO, Long iddemande);
    List<Equipe> getEquipesAffectees(Long opportuniteId);
    // get etude from opportunite
    Set<EtudeOpp> getEtude(Long id);

    Optional<OpportuniteDTO> affecterOpportuniteADemande(Long opportuniteId, Long demandeId);
    void setCreateOffreTrue(Long demandeId);
}
