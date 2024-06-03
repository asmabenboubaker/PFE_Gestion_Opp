package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.Offre;

import biz.picosoft.demo.service.dto.MonthlyOffreCountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the Offre entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OffreRepository extends JpaRepository<Offre, Long>, JpaSpecificationExecutor<Offre> {

    @Query("SELECT new biz.picosoft.demo.service.dto.MonthlyOffreCountDTO(YEAR(o.dateOffre), MONTH(o.dateOffre), COUNT(o)) " +
            "FROM Offre o " +
            "GROUP BY YEAR(o.dateOffre), MONTH(o.dateOffre)")
    List<MonthlyOffreCountDTO> findMonthlyOffreCount();

}
