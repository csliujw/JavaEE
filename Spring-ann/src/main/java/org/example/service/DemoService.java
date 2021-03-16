package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private String name = "HelloService";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoService{" +
                "name='" + name + '\'' +
                '}';
    }
}
