package org.example.controller;

import org.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        String tomcat = helloService.sayHello("tomcat");
        return tomcat;
    }

    @RequestMapping("/sc")
    public String index() {
        // 会自动补齐配置好的前缀和后缀的。
        return "index";
    }
}
