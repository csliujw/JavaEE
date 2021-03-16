package org.example.configuration.ioc.lifecycle;

import org.example.pojo.Car;
import org.example.pojo.Car2;
import org.example.pojo.Car3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LifeCycleConfiguration {

    // 可以在自定义数据源，用init和destroy进行数据源的初始化和关闭
    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

    @Bean
    public Car2 car2() {
        return new Car2();
    }

    @Bean
    public Car3 car3() {
        return new Car3();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        Object car2 = context.getBean("car2");
        Object car3 = context.getBean("car3");
        context.close();
//        Object car = annotationConfigApplicationContext.getBean("car");
//        annotationConfigApplicationContext.close();
        // 多实例的bean在获取时才创建对象
    }
}
