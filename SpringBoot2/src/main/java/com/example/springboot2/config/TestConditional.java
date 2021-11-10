package com.example.springboot2.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class TestConditional {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(TestConditional.class, args);
        System.out.println(run.getBean(Pet.class));
        String[] names = run.getBeanDefinitionNames();
        Arrays.stream(names)
                .filter(s -> s.contains("person") || s.contains("pet"))
                .forEach(System.out::println);
    }
}
