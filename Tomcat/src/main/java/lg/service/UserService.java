package lg.service;


import lg.dao.UserDao;
import lg.pojo.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}
