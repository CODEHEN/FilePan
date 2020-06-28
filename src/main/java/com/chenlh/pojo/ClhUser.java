package com.chenlh.pojo;

import java.io.Serializable;

/**
 * @Author: CHENLH
 * @Description:
 * @Date: Create in 23:08 2020/5/20
 */
public class ClhUser implements Serializable {
    private Integer id;
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ClhUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public ClhUser() {
    }
}
