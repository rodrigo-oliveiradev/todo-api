package com.oliveiradev.todo_api.dto;

import com.oliveiradev.todo_api.domain.Task;

public record TaskResponseDTO(
        Long id,
        String titulo,
        String descricao,
        String status,
        String prioridade,
        Long userId,
        String userEmail
) {

    public static TaskResponseDTO from(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitulo(),
                task.getDescricao(),
                task.getStatus().name(),
                task.getPrioridade().name(),
                task.getUser().getId(),
                task.getUser().getEmail()
        );
    }
}
