package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.domain.TacheOpp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TacheRepo  extends JpaRepository<TacheOpp, Long>, JpaSpecificationExecutor<TacheOpp> {
    List<TacheOpp> findByEtudeOppId(Long etudeOppId);
}
