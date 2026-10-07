package com.justiceserve.identityservice.controller;
import com.justiceserve.identityservice.dto.*;
import com.justiceserve.identityservice.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth") @RequiredArgsConstructor
@Tag(name = "2.1 Authentication")
public class AuthController {
    private final AuthService service;
    @PostMapping("/register")
    @Operation(summary = "Register — all users start as CITIZEN")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest req) { return ResponseEntity.ok(service.register(req)); }
    @PostMapping("/login")
    @Operation(summary = "Login — returns JWT token")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest req) { return ResponseEntity.ok(service.login(req)); }
}
