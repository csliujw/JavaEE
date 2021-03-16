package com.bbxx.dao;


import com.bbxx.pojo.RoleVO;

import java.util.List;


public interface IRoleDao {
    // 查询指定ID的所有User 一个角色 对应多个用户
    RoleVO findByPrimaryKey(Integer id);

    // 多对多查询，查询出所有的角色和角色对应的用户。
    List<RoleVO> findAllRole();
}
