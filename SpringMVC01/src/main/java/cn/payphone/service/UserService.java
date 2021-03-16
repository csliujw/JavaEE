package cn.payphone.service;

import cn.payphone.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User findById() {
        return new User("ljw", 17, "nanchang");
    }
}
