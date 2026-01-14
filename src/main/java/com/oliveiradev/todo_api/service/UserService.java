package com.oliveiradev.todo_api.service;

import com.oliveiradev.todo_api.domain.User;
import com.oliveiradev.todo_api.dto.UserRequestDTO;
import com.oliveiradev.todo_api.dto.UserResponseDTO;
import com.oliveiradev.todo_api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(passwordEncoder.encode(dto.senha()));
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