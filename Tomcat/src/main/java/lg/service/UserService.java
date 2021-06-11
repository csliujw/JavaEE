package lg.service;


import lg.dao.UserDao;
import lg.pojo.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class UserService {
    private UserDao userDao = new UserDao();

    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    public static void main(String[] args) throws FileNotFoundException {
        // 从package开始找
        InputStream resourceAsStream = UserService.class.getClassLoader().getResourceAsStream("nihaoya.txt");
        FileInputStream inputStream = new FileInputStream("/classes/123.txt");
        System.out.println(inputStream);
    }
}
