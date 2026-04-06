package com.devdevgo.backend.controller;

import com.devdevgo.backend.dto.UserProfileResponse;
import com.devdevgo.backend.dto.UserResponse;
import com.devdevgo.backend.dto.UserSignupRequest;
import com.devdevgo.backend.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public UserResponse signup(@Valid @RequestBody UserSignupRequest request) {
        return userService.signup(request);
    }

    @GetMapping("/{id}")
    public UserProfileResponse getUser(@PathVariable Long id) {
        return userService.getUserProfile(id);
    }
}