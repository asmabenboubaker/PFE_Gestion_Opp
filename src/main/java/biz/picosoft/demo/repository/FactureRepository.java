package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.Facture;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data SQL repository for the Facture entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FactureRepository extends JpaRepository<Facture, Long>, JpaSpecificationExecutor<Facture> {
    @EntityGraph(attributePaths = "invoiceItems")
    Optional<Facture> findById(Long id);
    //getTotalAmount
    @Query("SELECT COALESCE(SUM(f.totalAmount), 0) FROM Facture f")
    double getTotalAmount();
}
