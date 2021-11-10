package com.example.springboot2.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration(proxyBeanMethods = true)
@ImportResource("classpath:bean.xml")
public class MyConfig {
//    @Bean
//    public Pet tomcat() {
//        return new Pet();
//    }

    @Bean
    @ConditionalOnBean(name = {"tomcat"})
    public Person person() {
        Person person = new Person();
//        person.per = tomcat();
        return new Person();
    }
}
