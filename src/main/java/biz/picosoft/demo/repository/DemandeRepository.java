package biz.picosoft.demo.repository;


import biz.picosoft.demo.domain.Demande;

import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.service.dto.DemandeOutputDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data SQL repository for the Demande entity.
 */
@Repository
public interface DemandeRepository
    extends DemandeRepositoryWithBagRelationships, JpaRepository<Demande, Long>, JpaSpecificationExecutor<Demande> {
    default Optional<Demande> findOneWithEagerRelationships(Long id) {
        return this.fetchBagRelationships(this.findById(id));
    }

    default List<Demande> findAllWithEagerRelationships() {
        return this.fetchBagRelationships(this.findAll());
    }

    default Page<Demande> findAllWithEagerRelationships(Pageable pageable) {
        return this.fetchBagRelationships(this.findAll(pageable));
    }
    // count demande by domaine
//method to find the number demande in each domaine

  Long countByDomainesContains(Domaine domaine);


    Page<DemandeOutputDTO> findByActivityName(String activiteName, Pageable pageable);
    @Query("SELECT DATE_TRUNC('day', d.dateDeCreation) AS day, COUNT(d) FROM Demande d GROUP BY day")
    List<Object[]> findDemandesGroupedByDate();


}
