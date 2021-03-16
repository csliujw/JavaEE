package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public int update() {
        return 1;
    }

    public int delete() {
        return 1;
    }

    public String findById(String id) {
        return id + "success";
    }
}
