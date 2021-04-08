package com.ahao.java.music.dao;


import com.ahao.java.music.pojo.Admin;
import org.springframework.stereotype.Repository;


/*
* 管理员*/
@Repository
public interface AdminMapper {
    /*查询是否存在*/
    public Integer verifyPassword(Admin admin);

}
