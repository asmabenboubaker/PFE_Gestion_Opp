package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.PV;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the PV entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PVRepository extends JpaRepository<PV, Long>, JpaSpecificationExecutor<PV> {}
