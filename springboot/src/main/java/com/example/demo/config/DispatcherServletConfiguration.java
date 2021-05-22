package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;

/**
 * DispatcherServlet配置类，配置扫描web（Controller类）包
 */
@ComponentScan(basePackages = "com.example.demo.controller")
public class DispatcherServletConfiguration {
}
