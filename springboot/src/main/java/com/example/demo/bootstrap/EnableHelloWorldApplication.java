package com.example.demo.bootstrap;

import com.example.demo.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableHelloWorld
@ComponentScan(basePackages = "com.example.demo.bootstrap")
public class EnableHelloWorldApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        String str = context.getBean("helloWorld", String.class);
        System.out.println(str);
        context.close();
    }
}
