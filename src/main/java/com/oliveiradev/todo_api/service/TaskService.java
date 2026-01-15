package com.oliveiradev.todo_api.service;

import com.oliveiradev.todo_api.domain.Task;
import com.oliveiradev.todo_api.domain.User;
import com.oliveiradev.todo_api.domain.enums.PrioridadeTask;
import com.oliveiradev.todo_api.domain.enums.StatusTask;
import com.oliveiradev.todo_api.dto.TaskRequestDTO;
import com.oliveiradev.todo_api.dto.TaskResponseDTO;
import com.oliveiradev.todo_api.exception.ResourceNotFoundException;
import com.oliveiradev.todo_api.repository.TaskRepository;
import com.oliveiradev.todo_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    // Criar tarefa
    public TaskResponseDTO create(TaskRequestDTO dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Task task = new Task();
        task.setTitulo(dto.titulo());
        task.setDescricao(dto.descricao());
        task.setStatus(StatusTask.valueOf(dto.status()));
        task.setPrioridade(PrioridadeTask.valueOf(dto.prioridade()));
        task.setUser(user);

        Task saved = taskRepository.save(task);

        return TaskResponseDTO.from(saved);
    }

    // Buscar todas as tarefas
    public List<TaskResponseDTO> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(TaskResponseDTO::from)
                .toList();
    }

    // Buscar tarefas por usuário
    public List<TaskResponseDTO> findByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return taskRepository.findByUser(user)
                .stream()
                .map(TaskResponseDTO::from)
                .toList();
    }
}