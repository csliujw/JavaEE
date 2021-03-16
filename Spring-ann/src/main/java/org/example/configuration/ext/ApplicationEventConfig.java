package org.example.configuration.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationEventConfig {

    @Bean
    public MyApplicationEvent event() {
        return new MyApplicationEvent();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationEventConfig.class);
        context.publishEvent(new ApplicationEvent(new String("123")) {
        });
        context.close();
    }

}

class MyApplicationEvent implements ApplicationListener<ApplicationEvent> {
    // 当容器中发布此事件以后，方法触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(String.format("收到事件 %s", event));
    }
}
