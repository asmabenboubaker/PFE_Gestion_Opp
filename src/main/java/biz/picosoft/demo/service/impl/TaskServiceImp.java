package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.domain.Task;
import biz.picosoft.demo.repository.TaskRepository;
import biz.picosoft.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;


    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
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
}
