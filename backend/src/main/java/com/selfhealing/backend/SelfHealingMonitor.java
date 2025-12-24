package com.selfhealing.backend;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SelfHealingMonitor {

    private final HealthController healthController;

    public SelfHealingMonitor(HealthController healthController) {
        this.healthController = healthController;
    }
    @PostConstruct
    public void init() {
        System.out.println("SelfHealingMonitor bean CREATED");
    }

    @Scheduled(fixedDelay = 5000)
    public void monitorAndHeal() {
        if (!healthController.isHealthy()) {
            System.out.println("DOWN detected. Triggering recovery...");
            healthController.recover();
        }
    }
}
