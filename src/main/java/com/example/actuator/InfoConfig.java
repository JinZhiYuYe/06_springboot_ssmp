package com.example.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : jinye
 * @date : 2023/3/6 21:44
 */

@Component   // 自定springboot-admin中info信息
public class InfoConfig implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("runTime", System.currentTimeMillis());
        Map infoMap = new HashMap<>();
        infoMap.put("buildTime", 2023);
        builder.withDetails(infoMap);
    }
}
