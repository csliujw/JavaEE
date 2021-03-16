package org.example.configuration.ioc.assembly;

import org.example.pojo.Person;
import org.example.service.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "org.example", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = DemoService.class)
}, useDefaultFilters = false)
public class IncludeConfiguration {
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
