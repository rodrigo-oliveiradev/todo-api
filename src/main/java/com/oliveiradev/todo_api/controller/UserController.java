package com.oliveiradev.todo_api.controller;

import com.oliveiradev.todo_api.dto.UserRequestDTO;
import com.oliveiradev.todo_api.dto.UserResponseDTO;
import com.oliveiradev.todo_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO create(@RequestBody @Valid UserRequestDTO dto) {
        return userService.createUser(dto);
    }
}