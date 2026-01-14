package com.oliveiradev.todo_api.service;

import com.oliveiradev.todo_api.domain.User;
import com.oliveiradev.todo_api.dto.UserRequestDTO;
import com.oliveiradev.todo_api.dto.UserResponseDTO;
import com.oliveiradev.todo_api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(dto.senha());
        user.setRole("USER");

        User saved = userRepository.save(user);

        return new UserResponseDTO(
                saved.getId(),
                saved.getNome(),
                saved.getEmail(),
                saved.getRole()
        );
    }
}