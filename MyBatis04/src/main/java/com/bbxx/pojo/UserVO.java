package com.bbxx.pojo;

import java.util.List;

/**
 * 用户表 一个用户对应多种角色
 */
public class UserVO {
    private Integer id;
    private String username;
    private String birthday;
    private String address;
    private List<RoleVO> roleList;

    public List<RoleVO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleVO> roleList) {
        this.roleList = roleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
