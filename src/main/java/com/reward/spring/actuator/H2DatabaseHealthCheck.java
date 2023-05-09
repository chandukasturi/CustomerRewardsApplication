package com.reward.spring.actuator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class H2DatabaseHealthCheck implements HealthIndicator {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public H2DatabaseHealthCheck() {
    }

    public Health health() {
        try {
            List<String> customers = this.jdbcTemplate.queryForList("SELECT C_NAME FROM CUSTOMER", String.class);
            return customers.isEmpty() ? Health.down().withDetail("message", "No customers found").build() : Health.up().build();
        } catch (Exception var2) {
            return Health.down().withException(var2).build();
        }
    }
}
