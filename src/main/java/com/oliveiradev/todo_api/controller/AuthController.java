package com.oliveiradev.todo_api.controller;

import com.oliveiradev.todo_api.domain.User;
import com.oliveiradev.todo_api.dto.LoginRequestDTO;
import com.oliveiradev.todo_api.dto.LoginResponseDTO;
import com.oliveiradev.todo_api.repository.UserRepository;
import com.oliveiradev.todo_api.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        // Buscar usuário no banco
        User user = userRepository.findByEmail(body.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Verificar se a senha bate (senha digitada vs senha hash no banco)
        if (passwordEncoder.matches(body.senha(), user.getSenha())) {
            // Gerar Token
            String token = tokenService.generateToken(user);
            // Devolver JSON com nome e token
            return ResponseEntity.ok(new LoginResponseDTO(user.getNome(), token));
        }
        // Se a senha estiver errada
        return ResponseEntity.badRequest().build();
    }
}