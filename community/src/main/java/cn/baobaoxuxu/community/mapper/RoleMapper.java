package cn.baobaoxuxu.community.mapper;

import cn.baobaoxuxu.community.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    public List<Role> findAll();
}
