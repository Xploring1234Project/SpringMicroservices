package com.justiceserve.caseservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * Case Service — Member M3
 * Port: 8083
 * Handles: POST/GET/PATCH /api/cases/**, /api/files/**
 * DB: js_case_db (cases, case_documents, citizens tables)
 * Feign calls: notification-service, compliance-audit-service
 */
@SpringBootApplication @EnableDiscoveryClient @EnableFeignClients
public class CaseServiceApplication {
    public static void main(String[] args) { SpringApplication.run(CaseServiceApplication.class, args); }
}