package biz.picosoft.demo.service;

import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.domain.Task;
import biz.picosoft.demo.service.dto.TaskStatusStatisticsDTO;

import java.util.List;

public interface TaskService {


    Task save(Task task);

    Task findById(Long id);

    List<Task> findAll();

    void deleteById(Long id);
    Task updateTaskStatus(Long id, String status);

    List<Task> findByProject(Projet project);
    List<TaskStatusStatisticsDTO> getTaskStatusStatistics(Long projectId);
}
