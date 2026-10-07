package com.justiceserve.caseservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

/**
 * Feign → identity-service: fetch user data.
 * Does NOT create a local users table — fetches on demand.
 * FeignClientConfig forwards JWT automatically.
 */
@FeignClient(name = "identity-service", fallback = IdentityFeignClient.IdentityFeignFallback.class)
public interface IdentityFeignClient {
    @GetMapping("/api/users/{id}")
    UserDto getUserById(@PathVariable Long id);

    @GetMapping("/api/users/role/{role}")
    List<UserDto> getUsersByRole(@PathVariable String role);

    record UserDto(Long userId, String name, String email, String phone, String role, String status) {}

    @org.springframework.stereotype.Component
    class IdentityFeignFallback implements IdentityFeignClient {
        @Override public UserDto getUserById(Long id) { return null; }
        @Override public List<UserDto> getUsersByRole(String role) { return List.of(); }
    }
}
