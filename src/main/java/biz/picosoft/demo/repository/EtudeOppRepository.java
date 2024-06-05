package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.EtudeOpp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the EtudeOpp entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EtudeOppRepository extends JpaRepository<EtudeOpp, Long>, JpaSpecificationExecutor<EtudeOpp> {


    List<EtudeOpp> findAllByOpportuniteId(Long opportuniteId);
}
