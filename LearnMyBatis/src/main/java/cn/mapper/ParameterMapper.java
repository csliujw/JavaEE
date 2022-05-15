package cn.mapper;

import cn.pojo.User;

/**
 * mybatis 参数占位符的用法
 */
public interface Parameter {

    // 只有一个参数占位符
    public User getOne(int id);
    // 有多个形参
    public User getTwo(String name,String sex);
}
