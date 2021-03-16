
package com.bbxx.dao;

import com.bbxx.pojo.UserVO;

import java.util.List;

public interface IUserDao {

    // 查询所有
    List<UserVO> findAll();

    // 条件查询
    List<UserVO> findCondition(UserVO vo);

    // 删除
    Integer delete(Integer id);

    // 修改
    Boolean update(UserVO vo);

    // 新增
    Boolean insert(UserVO vo);

    // 模糊查询
    List<UserVO> findByName(String username);

    // 聚合函数
    Long findTotal();
}
