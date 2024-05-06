package biz.picosoft.demo.repository;


import biz.picosoft.demo.domain.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository  extends JpaRepository<Equipe, Long>, JpaSpecificationExecutor<Equipe> {
}
