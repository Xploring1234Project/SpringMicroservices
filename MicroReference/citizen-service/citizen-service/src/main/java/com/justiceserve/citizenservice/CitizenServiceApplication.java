package com.justiceserve.citizenservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * Module 2.2 — Citizen Registration & Profile Management
 * Port: 8082
 * Handles: /api/citizens/**
 * DB: js_citizen_db (citizens, citizen_documents)
 */
@SpringBootApplication @EnableDiscoveryClient @EnableFeignClients
public class CitizenServiceApplication {
    public static void main(String[] args) { SpringApplication.run(CitizenServiceApplication.class, args); }
}
