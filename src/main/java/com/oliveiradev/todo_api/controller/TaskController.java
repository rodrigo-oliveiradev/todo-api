package com.oliveiradev.todo_api.controller;

import com.oliveiradev.todo_api.domain.Task;
import com.oliveiradev.todo_api.domain.User;
import com.oliveiradev.todo_api.dto.TaskRequestDTO;
import com.oliveiradev.todo_api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Agora recebe o DTO e valida os campos (@NotBlank, etc)
    @PostMapping
    public Task createTask(@RequestBody @Valid TaskRequestDTO dto) {
        return taskService.createTask(dto);
    }

    @GetMapping
    public List<Task> listTasksByUser() {
        // Mock provisório até a gente ter o Login funcionando
        User user = new User();
        user.setId(1L);

        return taskService.findTasksByUser(user);
    }
}