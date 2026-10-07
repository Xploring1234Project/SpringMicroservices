package com.justiceserve.judgmentservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * Judgment Service — Member M5
 * Port: 8085
 * Handles: /api/judgments/**, /api/court-orders/**
 * Feign: case-service (close case), notification-service, compliance-audit-service
 */
@SpringBootApplication @EnableDiscoveryClient @EnableFeignClients
public class JudgmentServiceApplication {
    public static void main(String[] args) { SpringApplication.run(JudgmentServiceApplication.class, args); }
}