package com.bbxx.pojo;

import java.io.Serializable;

public class UserVO implements Serializable {
    private Integer id;
    private String username;
    private String birthday;
    private String address;
    public UserVO(){}
    public UserVO(Integer id, String username, String birthday){
        this.id = id;
        this.username = username;
        this.birthday = birthday;
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
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
