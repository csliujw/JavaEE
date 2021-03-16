package com.bbxx.pojo;

import java.io.Serializable;
import java.util.List;


/**
 * 角色表，一个角色对应多个用户
 */
public class RoleVO implements Serializable {
    private Integer id;

    private String roleName;

    private String roleDesc;


    private List<UserVO> userList;

    public List<UserVO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserVO> userList) {
        this.userList = userList;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "RoleVO{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", userList=" + userList +
                '}';
    }
}