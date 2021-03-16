package org.example.pojo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car3 {
    public Car3() {
        System.out.println("car3 construct");
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy");
    }

}
