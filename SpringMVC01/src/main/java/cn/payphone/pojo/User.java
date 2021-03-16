package cn.payphone.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;

public class User {

    @Length(min = 2, max = 18, message = "name长度错误，请确保2<=name长度<=18")
    private String name;
    @Max(value = 12, message = "请确保age>=12")
    private Integer age;
    @Length(min = 2, max = 18, message = "address长度错误，请确保2<=address长度<=18")
    private String address;

    public User() {
    }

    public User(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
