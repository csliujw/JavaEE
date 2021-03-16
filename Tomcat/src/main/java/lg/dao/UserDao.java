package lg.dao;


import lg.pojo.User;

public class UserDao {
    public User login(String username, String password) {
        if ("root".equals(username) && "root".equals(password)) {
            return new User(username, password);
        }
        return null;
    }
}
