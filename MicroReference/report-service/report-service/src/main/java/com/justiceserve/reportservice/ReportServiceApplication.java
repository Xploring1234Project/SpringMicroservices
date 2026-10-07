package com.justiceserve.reportservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * Report Service — Member M6
 * Port: 8088
 * Handles: /api/reports/**
 * Feign calls: case-service, hearing-service, judgment-service for metrics
 */
@SpringBootApplication @EnableDiscoveryClient @EnableFeignClients
public class ReportServiceApplication {
    public static void main(String[] args) { SpringApplication.run(ReportServiceApplication.class, args); }
}