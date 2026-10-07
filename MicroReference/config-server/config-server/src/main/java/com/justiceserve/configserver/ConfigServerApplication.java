package com.justiceserve.configserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * START SECOND (after eureka-server)
 * Port: 8888
 * Reads config from: https://github.com/Bharat613/justiceserve-config
 *
 * All service configs are in that GitHub repo:
 *   application.properties      — shared defaults for all services
 *   identity-service.properties — identity-service specific config
 *   citizen-service.properties  — citizen-service specific config
 *   ... etc
 *
 * Each microservice has ONLY bootstrap.properties which points here.
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
