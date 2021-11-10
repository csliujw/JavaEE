package com.example.demo;

import com.example.demo.controller.HelloWorldController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    HelloWorldController controller;

    @Test
    void contextLoads() {
        String hello = controller.hello();
        System.out.println(hello);
    }

}
