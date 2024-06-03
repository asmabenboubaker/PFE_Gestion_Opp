package biz.picosoft.demo.controller;


import biz.picosoft.demo.client.kernel.model.global.CurrentUser;
import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.domain.Task;
import biz.picosoft.demo.repository.ProjetRepository;
import biz.picosoft.demo.service.TaskService;
import biz.picosoft.demo.service.dto.TaskStatusStatisticsDTO;
import biz.picosoft.demo.service.impl.TaskServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
public class TaskResource {
    private final Logger log = LoggerFactory.getLogger(DemandeResource.class);

    private static final String ENTITY_NAME = "task";
    private final TaskService taskService;
    private TaskServiceImp taskServiceImp;
    private ProjetRepository projectRepository;
    private final CurrentUser currentUser;

    @Autowired
    public TaskResource(TaskService taskService,

                        TaskServiceImp taskServiceImp,
                        ProjetRepository projectRepository,
                        CurrentUser currentUser
                        ) {
        this.taskService = taskService;
        this.taskServiceImp = taskServiceImp;
        this.projectRepository = projectRepository;
        this.currentUser = currentUser;
    }
    @PostMapping("/{projectId}")
    public ResponseEntity<Task> createTask(@RequestBody Task task, @PathVariable Long projectId) {
        Projet project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project with id " + projectId + " not found."));
        task.setProject(project);
        task.setAssignee(currentUser.getEmployeSid());
        Task savedTask = taskService.save(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.findById(id);
        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @GetMapping("/all/{idproject}")
    public ResponseEntity<List<Task>> getAllTasksByProjectId(@PathVariable Long idproject) {
        Projet project = projectRepository.findById(idproject)
                .orElseThrow(() -> new IllegalArgumentException("Project with id " + idproject + " not found."));
        List<Task> tasks = taskService.findByProject(project);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Update task status endpoint
    @PutMapping("/{id}/{status}/status")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @PathVariable String status) {
        Task task = taskService.findById(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        task.setStatus(status);
        Task updatedTask = taskService.save(task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
    //update task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = taskService.findById(id);
        if (existingTask == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      task.setId(id);

        Task updatedTask = taskService.save(task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @PostMapping("/tasks/{taskId}/assign-to-project/{projectId}")
    public ResponseEntity<Task> assignTaskToProject(@PathVariable Long taskId, @PathVariable Long projectId) {
        Task result = taskServiceImp.assignTaskToProject(taskId, projectId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{projectId}/task-status-statistics")
    public ResponseEntity<List<TaskStatusStatisticsDTO>> getTaskStatusStatistics(@PathVariable Long projectId) {
        List<TaskStatusStatisticsDTO> statistics = taskService.getTaskStatusStatistics(projectId);
        return ResponseEntity.ok(statistics);
    }


}
