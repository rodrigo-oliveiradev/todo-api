package com.oliveiradev.todo_api.dto;

public record UserResponseDTO(
        Long id,
        String nome,
        String email,
        String role
) {
}
