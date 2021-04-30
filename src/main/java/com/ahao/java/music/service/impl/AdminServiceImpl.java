package com.ahao.java.music.service.impl;


import com.ahao.java.music.dao.AdminMapper;
import com.ahao.java.music.pojo.Admin;
import com.ahao.java.music.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {



    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Integer verifyPassword(Admin admin) {
        return adminMapper.verifyPassword(admin);
    }
}
