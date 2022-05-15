package cn.quickstart.mapper;

import cn.quickstart.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
