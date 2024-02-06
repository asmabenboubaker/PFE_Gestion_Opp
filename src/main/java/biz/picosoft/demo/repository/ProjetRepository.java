package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.Projet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Projet entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long>, JpaSpecificationExecutor<Projet> {}
