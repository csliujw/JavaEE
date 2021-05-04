package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {
    @ModelAttribute
    public String execute(Model model) {
        System.out.println("Advice");
        model.addAttribute("name", "ljw");
        return "!23";
    }
}
