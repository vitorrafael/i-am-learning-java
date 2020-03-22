package com.vitorrafael.awesome.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

// @EnableAutoConfiguration sets autoConfiguration to true
// @ComponentScans says where the endpoint is located
@EnableAutoConfiguration
@ComponentScan(basePackages="com.vitorrafael.awesome.endpoint")
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
