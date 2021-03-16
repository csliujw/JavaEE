package cn.baobaoxuxu.community.controller;

import cn.baobaoxuxu.community.mapper.RoleMapper;
import cn.baobaoxuxu.community.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyBatisController {
    @Autowired
    private RoleMapper mapper;

    @GetMapping("/findAll")
    public List<Role> findAll() {
        return mapper.findAll();
    }
}
