package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        String[] arg = new String[1];
//        arg[0] = "--server.port=8081";
        SpringApplication.run(Application.class, args);
    }

}
