package com.ahao.java.music.controller;


import com.ahao.java.music.config.BaseControllerStringToDate;
import com.ahao.java.music.pojo.Admin;
import com.ahao.java.music.pojo.Consumer;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.IConsumerService;
import com.ahao.java.music.service.MailService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 22720
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController extends BaseControllerStringToDate {

    @Autowired
    private IConsumerService iConsumerService;

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public Object selectAllConsumer() {
        List<Consumer> list = iConsumerService.selectAllConsumer();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", new Status(200, "查询成功", list));
        return jsonObject;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insertConsumer(Consumer consumer,@RequestParam("code")String code) {
        System.out.println(consumer);
        System.out.println(code);
        JSONObject jsonObject = new JSONObject();
        boolean result = iConsumerService.selectConsumerIsExist(consumer.getConsumerUserName());
        if (result) {
            jsonObject.put("data", new Status(204, "注册失败，该用户名已存在", null));
            return jsonObject;
        }
        boolean verifyResult = mailService.verifyCode(consumer.getConsumerEmail(), code);
        if (!verifyResult){
            jsonObject.put("data", new Status(204, "错误，验证码错误或验证码已过期", null));
            return  jsonObject;
        }
        iConsumerService.insertConsumer(consumer);
        jsonObject.put("data", new Status(200, "注册成功", consumer));
        return jsonObject;
    }

    @RequestMapping(value = "getEmailCode", method = RequestMethod.GET)
    public Object getEmailCode(String consumerEmail) {
        JSONObject jsonObject = new JSONObject();
        boolean existResult = iConsumerService.getEmailIsExist(consumerEmail);
        if (existResult) {
            jsonObject.put("data", new Status(204, "邮箱已经存在", null));
            return jsonObject;
        }
        boolean sendResult = mailService.sendMail(consumerEmail);
        if (sendResult) {
            jsonObject.put("data", new Status(200, "发送验证码成功", null));
            return jsonObject;
        }
        jsonObject.put("data", new Status(205, "服务器繁忙，稍后重试", null));
        return jsonObject;
    }

    @PostMapping("/login")
    public Object LoginStatus(Consumer consumer){
        JSONObject jsonObject=new JSONObject();
        Consumer consumer1;
        if ((consumer1=(iConsumerService.verifyPassword(consumer)))!=null){
            jsonObject.put("data",new Status(200,"登录成功",consumer1));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"登录失败，用户名或密码错误",null));
        return jsonObject;
    }
}
