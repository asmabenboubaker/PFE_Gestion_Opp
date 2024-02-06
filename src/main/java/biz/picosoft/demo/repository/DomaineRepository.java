package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.Domaine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Domaine entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Long>, JpaSpecificationExecutor<Domaine> {}
