package com.ahao.java.music.controller;


import com.ahao.java.music.pojo.Admin;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.IAdminService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private final IAdminService iAdminService;

    public AdminController(IAdminService iAdminService) {
        this.iAdminService = iAdminService;
    }


    @PostMapping("/admin/login")
    public Object LoginStatus(Admin admin){
        JSONObject jsonObject=new JSONObject();
        int id;
        System.out.println(admin);
        if ((id=iAdminService.verifyPassword(admin))>=0){
            jsonObject.put("data",new Status(200,"登录成功",id));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"登录失败",-1));
        return jsonObject;
    }
}
