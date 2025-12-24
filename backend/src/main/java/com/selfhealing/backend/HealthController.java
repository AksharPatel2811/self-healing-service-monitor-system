package com.selfhealing.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private boolean healthy = true;

    @GetMapping("/health")
    public String health() {
        return healthy ? "UP" : "DOWN";
    }

    @GetMapping("/crash")
    public String crash() {
        healthy = false;
        return "Service crashed";
    }

    // ===== Helper methods for self-healing =====

    public boolean isHealthy() {
        return healthy;
    }

    public void recover() {
        healthy = true;
        System.out.println("Service recovered automatically");
    }
}
