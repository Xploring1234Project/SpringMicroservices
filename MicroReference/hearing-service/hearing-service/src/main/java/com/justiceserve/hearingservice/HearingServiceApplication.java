package com.justiceserve.hearingservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * Hearing Service — Member M4
 * Port: 8084
 * Handles: POST/GET/PATCH /api/hearings/**, proceedings
 * Feign calls: case-service (update case status), notification-service, compliance-audit-service
 */
@SpringBootApplication @EnableDiscoveryClient @EnableFeignClients
public class HearingServiceApplication {
    public static void main(String[] args) { SpringApplication.run(HearingServiceApplication.class, args); }
}