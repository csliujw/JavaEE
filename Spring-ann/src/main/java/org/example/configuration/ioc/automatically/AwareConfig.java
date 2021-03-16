package org.example.configuration.ioc.automatically;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Configuration
@ComponentScan(basePackages = "org.example.configuration.ioc.automatically")
public class AwareConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        Dog bean = context.getBean(Dog.class);
//        context.close();
    }

}

@Component
class Dog implements ApplicationContextAware {


    private ApplicationContext context;

    /**
     * 再IOC创建启动dog对象时，这个方法会被调用
     *
     * @param context
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
        System.out.println("context hashcode is" + context);
    }

    public Dog() {
        System.out.println("class dog construct");
    }

    @PostConstruct
    public void init() {
        System.out.println("class dog post construct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("class dog destroy construct");
    }
}
