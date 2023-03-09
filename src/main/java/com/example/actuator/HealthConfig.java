package com.example.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : jinye
 * @date : 2023/3/7 12:41
 */

@Component
public class HealthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.withDetail("runTime", System.currentTimeMillis());
        Map infoMap = new HashMap<>();
        infoMap.put("buildTime", 2023);
        builder.withDetails(infoMap);
//        builder.up();
        builder.status(Status.UP);
    }
}
