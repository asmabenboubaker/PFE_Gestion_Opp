package biz.picosoft.demo.service;

import biz.picosoft.demo.domain.Task;

import java.util.List;

public interface TaskService {


    Task save(Task task);

    Task findById(Long id);

    List<Task> findAll();

    void deleteById(Long id);
}
