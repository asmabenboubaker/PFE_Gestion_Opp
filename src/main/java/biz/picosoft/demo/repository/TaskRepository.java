package biz.picosoft.demo.repository;


import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
}
