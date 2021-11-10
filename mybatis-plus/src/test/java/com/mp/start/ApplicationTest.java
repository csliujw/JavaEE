package com.mp.start;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.start.mapper.UserMapper;
import com.mp.start.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    UserMapper mapper;

    @Test
    public void first() {
        mapper.selectList(null);
    }

    @Test
    public void insert() {
        // 默认 id 的策略为雪花算法
        User user = new User(null, "name", "pwd", "name", 18, "hello");
        for (int i = 0; i < 10; i++) {
            mapper.insert(user);
        }
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1L);
        user.setUserName("liujiawei");
        this.mapper.updateById(user);
    }

    @Test
    public void updateByCondition() {
        User user = new User();
        user.setId(1L);
        user.setMail("hahahah11131231");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "liujiawei");
        this.mapper.update(user, wrapper);
    }

    @Test
    public void deleteById() {
        this.mapper.deleteById(8);
    }

    @Test
    public void deleteByCondition() {
        HashMap<String, Object> col = new HashMap<>();
        col.put("id", 7L);
        col.put("password", "pwd");
        this.mapper.deleteByMap(col);
    }

    @Test
    public void deleteByWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 7L).or().eq("email", "hello");
        mapper.delete(wrapper);
    }

    @Test
    public void deleteBatchIds() {
        mapper.deleteBatchIds(Arrays.asList(7, 8, 9, 10, 11, 12, 13));
    }

    @Test
    public void selectPage() {
        Page<User> page = new Page<>();
        page.setCurrent(1);
        page.setSize(2);
        mapper.selectPage(page, null);
    }

}
