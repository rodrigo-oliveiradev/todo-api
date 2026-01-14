package com.oliveiradev.todo_api.dto;

import jakarta.validation.constraints.NotBlank;

public record TaskRequestDTO(
        @NotBlank
        String titulo,

        String descricao,

        @NotBlank
        String status,

        @NotBlank
        String prioridade,

        Long userId
) {
}
