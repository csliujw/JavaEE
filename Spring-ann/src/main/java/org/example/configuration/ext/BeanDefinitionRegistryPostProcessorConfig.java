package org.example.configuration.ext;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanDefinitionRegistryPostProcessorConfig {

    @Bean
    public MyBeanDefinitionRegistryPostProcessor get() {
        return new MyBeanDefinitionRegistryPostProcessor();
    }


    public static void main(String[] args) {
        /**
         * 这个测试流程如下：
         *  postProcessBeanDefinitionRegistry 获取到的注册的bean数目为 7，有注册一个后 为 8
         *  postProcessBeanFactory 获取到的注册的bean数目  为 8.
         *  这说明了  Registry先执行于Factory
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanDefinitionRegistryPostProcessorConfig.class);
        context.close();
    }
}

class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println(String.format("postProcessBeanDefinitionRegistry拥有的类数量为 %d", registry.getBeanDefinitionCount()));
        // 可在这里进行bean的注册
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
        registry.registerBeanDefinition("blue", beanDefinition);
        System.out.println(String.format("postProcessBeanDefinitionRegistry又注册了一个bean %s", "blue"));
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(String.format("postProcessBeanFactory拥有的bean数量 %d", beanFactory.getBeanDefinitionCount()));
    }
}
