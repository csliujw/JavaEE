package cn.payphone.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class Exceptions {
    static {
        System.out.println("hello Exception");
    }

    @ExceptionHandler(value = {Exception.class})
    public ModelAndView exception(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("ex", e);
        return modelAndView;
    }
}
