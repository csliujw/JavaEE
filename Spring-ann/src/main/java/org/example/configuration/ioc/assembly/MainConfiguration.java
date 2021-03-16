package org.example.configuration.ioc.assembly;

import org.example.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackages = "org.example", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
}, useDefaultFilters = false)
public class MainConfiguration {
    // 给容器中注册一个Bean
    @Bean(name = {"person1", "person2", "person3"})
    public Person person() {
        return new Person();
    }

    @Bean
    public Person person007() {
        return new Person();
    }
}
