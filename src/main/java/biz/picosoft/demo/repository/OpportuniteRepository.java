package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.Opportunite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Opportunite entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OpportuniteRepository extends JpaRepository<Opportunite, Long>, JpaSpecificationExecutor<Opportunite> {}
