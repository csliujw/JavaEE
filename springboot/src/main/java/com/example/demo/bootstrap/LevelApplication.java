package com.example.demo.bootstrap;

import com.example.demo.repository.MyFirstRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.demo.repository")
public class LevelApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(LevelApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        MyFirstRepository myFirstRepository = context.getBean("myFirstRepository", MyFirstRepository.class);
        System.out.println(myFirstRepository);
        context.close();
    }
}
