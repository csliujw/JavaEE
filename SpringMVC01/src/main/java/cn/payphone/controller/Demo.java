package cn.payphone.controller;

import cn.payphone.pojo.User;
import cn.payphone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class Demo {
    @Autowired
    UserService userService;

    @RequestMapping("/user/{id}")
    public User findById(@PathVariable Integer id) {
        System.out.println(id);
        return userService.findById();
    }

    @RequestMapping("/user/2")
    public User findById2() {
        return userService.findById();
    }
}
