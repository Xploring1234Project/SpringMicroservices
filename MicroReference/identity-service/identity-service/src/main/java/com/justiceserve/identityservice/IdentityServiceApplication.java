package com.justiceserve.identityservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * Module 2.1 — Identity & Access Management
 * Port: 8081 (from GitHub config)
 * DB: justice-serve-identity
 * Endpoints: /api/auth/register, /api/auth/login, /api/users/**
 */
@SpringBootApplication @EnableDiscoveryClient @EnableFeignClients
public class IdentityServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IdentityServiceApplication.class, args);
    }
}
