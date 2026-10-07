package com.justiceserve.complianceservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * Compliance & Audit Service — Member M6
 * Port: 8087
 * Handles: /api/compliance/**, /api/audits/**, /api/audit-logs/**
 * Also exposes POST /api/audit-logs/internal — called by ALL other services via Feign.
 * DB: js_compliance_db (compliance_records, audits, audit_logs)
 */
@SpringBootApplication @EnableDiscoveryClient @EnableFeignClients
public class ComplianceServiceApplication {
    public static void main(String[] args) { SpringApplication.run(ComplianceServiceApplication.class, args); }
}