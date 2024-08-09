package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.Opportunite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the Opportunite entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OpportuniteRepository extends JpaRepository<Opportunite, Long>, JpaSpecificationExecutor<Opportunite> {
    @Query("SELECT DATE_TRUNC('day', d.createAt) AS day, COUNT(d) FROM Opportunite d GROUP BY day")
    List<Object[]> findOpportuniteGroupedByDate();

}
