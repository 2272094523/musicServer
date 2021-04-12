package com.ahao.java.music.controller;


import com.ahao.java.music.pojo.Consumer;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.IConsumerService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 22720
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private IConsumerService iConsumerService;

    @RequestMapping(value = "selectAll" ,method = RequestMethod.GET)
    public Object selectAllConsumer(){
        List<Consumer> list = iConsumerService.selectAllConsumer();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",list));
        return jsonObject;
    }
}
