package com.example.demo.bootstrap;

import com.example.demo.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.example.demo")
public class ConditionalOnSystemPropertyApplication {

    // 条件满足产生类"hello",不满足则不产生。
    @Bean
    @ConditionalOnSystemProperty(name = "java", value = "java")
    public String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        String str = context.getBean("hello", String.class);
        System.out.println(str);
        context.close();
    }
}
