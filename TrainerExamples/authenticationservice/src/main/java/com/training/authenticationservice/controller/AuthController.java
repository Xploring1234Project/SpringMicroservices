package com.training.authenticationservice.controller;

import com.training.authenticationservice.dto.AuthRequestDTO;
import com.training.authenticationservice.dto.AuthResoponseDTO;
import com.training.authenticationservice.dto.UserDTO;
import com.training.authenticationservice.feignclient.UserClient;
import com.training.authenticationservice.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;

        @Autowired
        private JwtUtil jwtUtil;

        private final UserClient userClient;

   // @PreAuthorize("permitAll()")
        @PostMapping("/login")
        public ResponseEntity<?> login(
                @RequestBody AuthRequestDTO request) {

            Authentication authentication =
                    authManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(),
                                    request.getPassword()));


            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            String role = userDetails.getAuthorities()
                    .iterator()
                    .next()
                    .getAuthority();

            String token = jwtUtil.generateToken(userDetails.getUsername(), role);

            return ResponseEntity.ok(new AuthResoponseDTO(token));


        }
    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO userDto)
    {
        return userClient.registerUser(userDto);
    }

}

