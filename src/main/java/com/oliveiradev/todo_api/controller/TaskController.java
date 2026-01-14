package com.oliveiradev.todo_api.controller;

import com.oliveiradev.todo_api.domain.Task;
import com.oliveiradev.todo_api.domain.User;
import com.oliveiradev.todo_api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> listTasksByUser() {
        // por enquanto vou mockar o usuário
        User user = new User();
        user.setId(1L);

        return taskService.findTasksByUser(user);
    }
}
