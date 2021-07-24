package com.imooc.firstappdemo.controller;

import com.imooc.firstappdemo.dao.UserRepository;
import com.imooc.firstappdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save() {
        User user = new User();
        if (userRepository.save(user)) {
            System.out.printf("用户对象 %s 保存成功！\n", user);
        }
        return user;
    }

}
