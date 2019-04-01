package com.ascendmoney.td.server.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.HealthStatusHttpMapper;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Auto-configures the health and info endpoint back to the application port for
 * the monitoring systems
 * @author Phea.Soy
 */
@RestController
@Configuration
public class AutoReconfigureMonitor {

    final HealthEndpoint healthEndpoint;
    final HealthStatusHttpMapper statusMapper;
    final InfoEndpoint infoEndpoint;

    AutoReconfigureMonitor(HealthEndpoint healthEndpoint, HealthStatusHttpMapper statusMapper,
                           InfoEndpoint infoEndpoint) {
        this.healthEndpoint = healthEndpoint;
        this.statusMapper = statusMapper;
        this.infoEndpoint = infoEndpoint;
    }

    @GetMapping("/health")
    public ResponseEntity getHealth() {
        Health health = healthEndpoint.health();
        return ResponseEntity.status(statusMapper.mapStatus(health.getStatus())).body(health);
    }

    @GetMapping("/info")
    public ResponseEntity getInfo() {
        return ResponseEntity.ok(infoEndpoint.info());
    }
}