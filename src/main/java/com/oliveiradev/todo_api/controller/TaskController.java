package com.oliveiradev.todo_api.controller;

import com.oliveiradev.todo_api.dto.TaskRequestDTO;
import com.oliveiradev.todo_api.dto.TaskResponseDTO;
import com.oliveiradev.todo_api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Criar tarefa
    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(
            @Valid @RequestBody TaskRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskService.create(dto));
    }

    // Listar todas as tarefas
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    // Listar tarefas por usuário
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskResponseDTO>> findByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(taskService.findByUser(userId));
    }
}