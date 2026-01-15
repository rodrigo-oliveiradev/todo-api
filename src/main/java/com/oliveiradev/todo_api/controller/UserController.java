package com.oliveiradev.todo_api.controller;

import com.oliveiradev.todo_api.dto.UserRequestDTO;
import com.oliveiradev.todo_api.dto.UserResponseDTO;
import com.oliveiradev.todo_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(
            @Valid @RequestBody UserRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(dto));
    }
}