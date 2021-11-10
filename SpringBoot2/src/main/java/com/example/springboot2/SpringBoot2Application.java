package com.example.springboot2;

import com.example.springboot2.config.MyConfig;
import com.example.springboot2.config.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.event.PaintEvent;
import java.util.Arrays;

@SpringBootApplication
@RestController
public class SpringBoot2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBoot2Application.class, args);
        // MyConfig$$EnhancerBySpringCGLIB$$cf24ac66@2c54c0c0 代理的
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

    }


    @GetMapping("/index")
    public String get() {
        return "!@#";
    }
}
