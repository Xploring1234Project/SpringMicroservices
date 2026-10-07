package com.justiceserve.gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * START LAST — API Gateway
 * Port: 8080 (from GitHub config)
 * All Angular requests go through here.
 * JWT is validated here. X-User-* headers forwarded to services.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
