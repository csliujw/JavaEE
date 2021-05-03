package com.example.demo.config;

import com.example.demo.annotation.EnableHelloWorld;
import com.example.demo.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld自动装配
 */
@Configuration
@EnableHelloWorld // Spring @Enable模块装配
@ConditionalOnSystemProperty(name = "kkx", value = "kkx")
public class HelloWorldAutoConfiguration {
    @Bean
    public Object getObj() {
        return new Object();
    }
}
