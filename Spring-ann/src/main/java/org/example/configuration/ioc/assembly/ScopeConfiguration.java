package org.example.configuration.ioc.assembly;

import org.example.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfiguration {

    @Scope("prototype")
    @Bean
    public Person person() {
        return new Person("asdf");
    }
}
