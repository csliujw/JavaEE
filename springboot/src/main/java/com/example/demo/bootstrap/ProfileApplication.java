package com.example.demo.bootstrap;

import com.example.demo.service.Calculate;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.demo")
public class ProfileApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ProfileApplication.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run();
        Calculate bean = context.getBean(Calculate.class);
        System.out.println(bean.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    }
}
