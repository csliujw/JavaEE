package com.example.springboot2.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties({MyCar.class})
public class TestMyCar {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(TestMyCar.class, args);
        MyCar bean = run.getBean(MyCar.class);
        System.out.println(bean.price);
    }
}
