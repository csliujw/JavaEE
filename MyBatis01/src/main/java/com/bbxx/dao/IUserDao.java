
package com.bbxx.dao;

import com.bbxx.pojo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
    List<UserVO> findAll();

    List<UserVO> findByCondition(UserVO vo);

    boolean insert(UserVO vo);

    long delete(UserVO vo);

    UserVO selectOne(String username);

    UserVO selectOne2(@Param("username") String name);

    UserVO selectOne3(String name);

    UserVO selectOne4(String xx);

}
