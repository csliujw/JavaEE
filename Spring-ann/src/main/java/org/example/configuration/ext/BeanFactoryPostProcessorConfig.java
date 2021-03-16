package org.example.configuration.ext;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class BeanFactoryPostProcessorConfig {

    @Bean
    public MyBeanFactoryPostProcessor process() {
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public Blue blue() {
        return new Blue();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfig.class);
        context.close();
        /**
         * out put
         * my bean factory execute MyBeanFactoryPostProcessor
         * 当前BeanFactory中有8个Bean
         * Blue constructor
         * 证明了是先注册组件，然后执行postProcessBeanFactory，最后在创建对象
         */
    }
}

class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("my bean factory execute MyBeanFactoryPostProcessor");
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("当前BeanFactory中有" + beanDefinitionCount + "个Bean");
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}

class Blue {
    public Blue() {
        System.out.println("Blue constructor");
    }
}