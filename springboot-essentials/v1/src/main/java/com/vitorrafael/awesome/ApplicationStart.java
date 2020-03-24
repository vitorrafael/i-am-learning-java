package com.vitorrafael.awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

// @EnableAutoConfiguration sets autoConfiguration to true
// @ComponentScans is used to scan an specific packages
// @ComponentScan will scan all sub-packages
// @Configuration configures with the classes created withholding the information
// @SpringBootApplication is basically the sum of all above annotations
@SpringBootApplication
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
