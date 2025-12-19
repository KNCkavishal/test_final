package com.ecotrip.ecotrip_backend.controller;

import com.ecotrip.ecotrip_backend.model.SignupRequest;
import com.ecotrip.ecotrip_backend.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserServiceImpl userService;

    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest request) {
        try {
            userService.register(request);
            return ResponseEntity.ok("Signup successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignupRequest request) {
        try {
            userService.login(request.getEmail(), request.getPassword());
            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
