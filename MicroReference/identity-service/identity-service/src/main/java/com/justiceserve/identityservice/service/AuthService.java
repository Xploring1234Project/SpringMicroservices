package com.justiceserve.identityservice.service;
import com.justiceserve.identityservice.dto.*;
public interface AuthService {
    AuthResponse register(RegisterRequest req);
    AuthResponse login(LoginRequest req);
}
