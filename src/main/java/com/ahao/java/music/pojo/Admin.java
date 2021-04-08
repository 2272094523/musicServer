package com.ahao.java.music.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer Admin_id;
    private String Admin_name;
    private String Admin_password;

    public Admin() {
    }

    public Admin(String admin_name, String admin_password) {
        this.Admin_name=admin_name;
        this.Admin_password=admin_password;
    }

    public Admin(Integer admin_id, String admin_name, String admin_password) {
        Admin_id = admin_id;
        Admin_name = admin_name;
        Admin_password = admin_password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAdmin_id() {
        return Admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        Admin_id = admin_id;
    }

    public String getAdmin_name() {
        return Admin_name;
    }

    public void setAdmin_name(String admin_name) {
        Admin_name = admin_name;
    }

    public String getAdmin_password() {
        return Admin_password;
    }

    public void setAdmin_password(String admin_password) {
        Admin_password = admin_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Admin_id=" + Admin_id +
                ", Admin_name='" + Admin_name + '\'' +
                ", Admin_password='" + Admin_password + '\'' +
                '}';
    }
}

