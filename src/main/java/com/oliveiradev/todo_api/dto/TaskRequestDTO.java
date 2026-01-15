package com.oliveiradev.todo_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequestDTO(
        @NotBlank(message = "Título é obrigatório")
        String titulo,

        String descricao,

        @NotBlank(message = "Status é obrigatório")
        String status,

        @NotBlank(message = "Prioridade é obrigatória")
        String prioridade,

        @NotNull(message = "UserId é obrigatório")
        Long userId
) {}

