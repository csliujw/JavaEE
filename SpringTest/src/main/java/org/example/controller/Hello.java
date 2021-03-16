package org.example.controller;

import org.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @Autowired
    private HelloService service;

    @GetMapping("/update")
    public int update() {
        return service.update();
    }

    @GetMapping("/delete")
    public int delete() {
        return service.delete();
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable String id) {
        return service.findById(id);
    }
}
