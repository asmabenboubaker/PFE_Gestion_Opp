package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.domain.Task;
import biz.picosoft.demo.repository.ProjetRepository;
import biz.picosoft.demo.repository.TaskRepository;
import biz.picosoft.demo.service.TaskService;
import biz.picosoft.demo.service.dto.TaskStatusStatisticsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;
private final ProjetRepository projectRepository;

    public TaskServiceImp(TaskRepository taskRepository,
                            ProjetRepository projectRepository
    ) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }
    @Override
    public Task save(Task task) {



        return taskRepository.save(task);
    }


    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTaskStatus(Long id, String status) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setStatus(status);

            return taskRepository.save(task);
        } else {
            return null; // Handle task not found case
        }
    }

    @Override
    public List<Task> findByProject(Projet project) {
        return taskRepository.findByProject(project);
    }

    @Override
    public List<TaskStatusStatisticsDTO> getTaskStatusStatistics(Long projectId) {
        return taskRepository.findTaskStatusStatisticsByProjectId(projectId);
    }


    public Task assignTaskToProject(Long taskId, Long projectId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task with id " + taskId + " not found."));
        Projet project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project with id " + projectId + " not found."));
        task.setProject(project);
        return taskRepository.save(task);
    }
}
