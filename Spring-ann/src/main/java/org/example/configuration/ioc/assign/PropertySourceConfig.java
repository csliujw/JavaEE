package org.example.configuration.ioc.assign;

import org.example.pojo.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
// 使用@PropertySource读取外部配置文件中的k/v保存到运行的环境中
@PropertySource(value = {"classpath:/person.properties"})
public class PropertySourceConfig {

    @Bean
    public Person person() {
        return new Person();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertySourceConfig.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println(environment.getProperty("person.name"));
        Person person = context.getBean(Person.class, "person");
        System.out.println(person);
    }
}
