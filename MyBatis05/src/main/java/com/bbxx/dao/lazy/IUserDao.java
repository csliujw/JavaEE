package com.bbxx.dao.lazy;

import com.bbxx.pojo.Account;
import com.bbxx.pojo.User;

import java.util.List;

public interface IUserDao {
    User findOne(Integer id);

    // 懒加载 一对多查询 查询每个用户的所有账户信息
    List<User> findAll();
}
