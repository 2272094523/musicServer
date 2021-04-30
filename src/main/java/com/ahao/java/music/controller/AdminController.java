package com.ahao.java.music.controller;


import com.ahao.java.music.pojo.Admin;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.IAdminService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private final IAdminService iAdminService;

    public AdminController(IAdminService iAdminService) {
        this.iAdminService = iAdminService;
    }


    @PostMapping("/login")
    public Object LoginStatus(Admin admin){
        JSONObject jsonObject=new JSONObject();
        Integer id;
        if ((id=iAdminService.verifyPassword(admin))!=null){
            jsonObject.put("data",new Status(200,"登录成功",id));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"登录失败",-1));
        return jsonObject;
    }
}
