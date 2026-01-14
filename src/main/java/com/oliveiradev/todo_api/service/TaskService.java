package com.oliveiradev.todo_api.service;

import com.oliveiradev.todo_api.domain.Task;
import com.oliveiradev.todo_api.domain.User;
import com.oliveiradev.todo_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }
}