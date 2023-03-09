package com.example.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

/**
 * @author : jinye
 * @date : 2023/3/7 12:59
 */
@Component
@Endpoint(id = "pay", enableByDefault = true)   // 自定义端点
public class PayEndpoint{

    @ReadOperation
    public Object getPay(){
        System.out.println("--------------------");
        System.out.println("---------pay--------");
        System.out.println("--------------------");
        return "你支付，我快乐";
    }
}
