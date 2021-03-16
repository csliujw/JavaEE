package org.example.configuration.ioc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class BeanPostProcessConfiguration {

    @Bean
    public BeanPostProcessDemo demo() {
        return new BeanPostProcessDemo();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanPostProcessConfiguration.class);
        context.close();
    }
}

@Component
class BeanPostProcessDemo implements BeanPostProcessor {
    public BeanPostProcessDemo() {
        System.out.println("construct");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before initialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after initialization");
        return bean;
    }

}