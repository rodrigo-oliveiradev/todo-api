package com.oliveiradev.todo_api.service;

import com.oliveiradev.todo_api.domain.Task;
import com.oliveiradev.todo_api.domain.User;
import com.oliveiradev.todo_api.domain.enums.PrioridadeTask;
import com.oliveiradev.todo_api.domain.enums.StatusTask;
import com.oliveiradev.todo_api.dto.TaskRequestDTO;
import com.oliveiradev.todo_api.repository.TaskRepository;
import com.oliveiradev.todo_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    // Pode manter por enquanto
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(TaskRequestDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();
        task.setTitulo(dto.getTitulo());
        task.setDescricao(dto.getDescricao());
        task.setStatus(StatusTask.valueOf(dto.getStatus()));
        task.setPrioridade(PrioridadeTask.valueOf(dto.getPrioridade()));

        task.setUser(user);

        return taskRepository.save(task);
    }
}
