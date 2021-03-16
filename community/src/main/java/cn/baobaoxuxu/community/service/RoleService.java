package cn.baobaoxuxu.community.service;

import cn.baobaoxuxu.community.mapper.RoleMapper;
import cn.baobaoxuxu.community.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleMapper mapper;

    public List<Role> findAll() {
        return mapper.findAll();
    }
}
