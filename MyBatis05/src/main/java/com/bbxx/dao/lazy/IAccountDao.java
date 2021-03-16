package com.bbxx.dao.lazy;

import com.bbxx.pojo.Account;

import java.util.List;

/**
 *
 */
public interface IAccountDao {
    // 懒加载案例，只查账号不查用户信息 一对一
    List<Account> findAll();

    List<Account> findById(Integer id);
}
