package com.bbxx.dao;


import com.bbxx.pojo.UserVO;

import java.util.List;

public interface IUserDao {


    // 删除 -- 测试事务
    Integer delete(Integer id);

    // 查询所有 -- 查看事务是否成功提交
    List<UserVO> findAll();

    // 条件查询 -- 动态SQL 之if
    List<UserVO> findCondition(UserVO vo);

    // 条件查询 -- 动态SQL 之where
    List<UserVO> findCondition2(UserVO vo);

    // 新增 -- 动态SQL 之 set
    boolean update(UserVO vo);

    // 循环新增 -- 动态SQL 之 foreach
    Long insertBatch(List<UserVO> vos);

    // 循环删除 -- 动态SQL之 foreach 数组
    Long deleteBatch(Integer[] ids);

    // 循环删除 -- 动态SQL之 foreach 集合
    Long deleteBatch(List<Integer> lists);

}
