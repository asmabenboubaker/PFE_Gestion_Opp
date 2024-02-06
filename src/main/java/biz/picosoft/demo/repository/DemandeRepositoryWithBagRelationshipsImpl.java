package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.Demande;

import org.hibernate.annotations.QueryHints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Utility repository to load bag relationships based on https://vladmihalcea.com/hibernate-multiplebagfetchexception/
 */
public class DemandeRepositoryWithBagRelationshipsImpl implements DemandeRepositoryWithBagRelationships {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Demande> fetchBagRelationships(Optional<Demande> demande) {
        return demande.map(this::fetchDomaines);
    }

    @Override
    public Page<Demande> fetchBagRelationships(Page<Demande> demandes) {
        return new PageImpl<>(fetchBagRelationships(demandes.getContent()), demandes.getPageable(), demandes.getTotalElements());
    }

    @Override
    public List<Demande> fetchBagRelationships(List<Demande> demandes) {
        return Optional.of(demandes).map(this::fetchDomaines).orElse(Collections.emptyList());
    }

    Demande fetchDomaines(Demande result) {
        return entityManager
            .createQuery("select demande from Demande demande left join fetch demande.domaines where demande is :demande", Demande.class)
            .setParameter("demande", result)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getSingleResult();
    }

    List<Demande> fetchDomaines(List<Demande> demandes) {
        return entityManager
            .createQuery(
                "select distinct demande from Demande demande left join fetch demande.domaines where demande in :demandes",
                Demande.class
            )
            .setParameter("demandes", demandes)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getResultList();
    }
}
