package lg.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Users {
    private Integer id;
    private String username;
    private String birthday;
    private String address;

    public Users() {
        List<Object> l = new ArrayList<>();
    }

    public Users(Integer id, String username, String birthday, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.address = address;
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
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) &&
                Objects.equals(username, users.username) &&
                Objects.equals(birthday, users.birthday) &&
                Objects.equals(address, users.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, birthday, address);
    }
}
