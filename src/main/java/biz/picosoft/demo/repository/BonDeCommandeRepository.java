package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.BonDeCommande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the BonDeCommande entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BonDeCommandeRepository extends JpaRepository<BonDeCommande, Long>, JpaSpecificationExecutor<BonDeCommande> {}
