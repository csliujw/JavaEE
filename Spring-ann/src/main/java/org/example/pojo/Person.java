package org.example.pojo;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    // 使用@Value赋值
    // 1 基本数值
    // 2 可以写SpEL， #{}，取出配置文件中的值
//    @Value("${person.name}")
    private String name;
    @Value("#{20-5}")
    private Integer age;


    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
