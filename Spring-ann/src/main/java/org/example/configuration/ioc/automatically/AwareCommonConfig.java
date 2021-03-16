package org.example.configuration.ioc.automatically;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 常用的Aware接口
 */
@Configuration
@ComponentScan(basePackages = "org.example.configuration.ioc.automatically")
public class AwareCommonConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareCommonConfig.class);
        AwareCommonDemo bean = context.getBean(AwareCommonDemo.class);
        System.out.println(bean);
    }
}

@Component
class AwareCommonDemo implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    private ApplicationContext context;

    @Override
    public void setBeanName(String name) {
        // 设置bean的名字
        System.out.println("setBeanName is " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
        System.out.println("setApplicationContext " + context);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("os.name is ${os.name} Spring EL #{12-5}");
        System.out.println("setEmbeddedValueResolver is " + s);
    }
}
