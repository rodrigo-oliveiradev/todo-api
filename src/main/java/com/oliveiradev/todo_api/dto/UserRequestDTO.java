package com.oliveiradev.todo_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String senha
) {
}
