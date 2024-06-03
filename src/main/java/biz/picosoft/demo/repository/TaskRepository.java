package biz.picosoft.demo.repository;


import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.domain.Task;
import biz.picosoft.demo.service.dto.TaskStatusStatisticsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

    List<Task> findByProject(Projet project);
    @Query("SELECT new biz.picosoft.demo.service.dto.TaskStatusStatisticsDTO(t.status, COUNT(t)) " +
            "FROM Task t WHERE t.project.id = :projectId GROUP BY t.status")
    List<TaskStatusStatisticsDTO> findTaskStatusStatisticsByProjectId(Long projectId);
}
