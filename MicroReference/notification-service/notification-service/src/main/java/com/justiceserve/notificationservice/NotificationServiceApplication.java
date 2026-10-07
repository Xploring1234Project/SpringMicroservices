package com.justiceserve.notificationservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * Notification Service — Member M1
 * Port: 8086
 * Called by other services via FeignClient to send notifications.
 * Also exposes GET/PATCH endpoints for Angular frontend.
 */
@SpringBootApplication @EnableDiscoveryClient @EnableFeignClients
public class NotificationServiceApplication {
    public static void main(String[] args) { SpringApplication.run(NotificationServiceApplication.class, args); }
}