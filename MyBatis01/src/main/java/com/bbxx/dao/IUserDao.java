
package com.bbxx.dao;

import com.bbxx.pojo.UserVO;

import java.util.List;

public interface IUserDao {
    List<UserVO> findAll();

    List<UserVO> findByCondition(UserVO vo);
}
