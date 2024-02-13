package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.Demande;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DemandeRepositoryWithBagRelationships {
    Optional<Demande> fetchBagRelationships(Optional<Demande> demande);

    List<Demande> fetchBagRelationships(List<Demande> demandes);

    Page<Demande> fetchBagRelationships(Page<Demande> demandes);
}
