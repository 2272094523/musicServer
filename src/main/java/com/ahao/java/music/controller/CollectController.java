package com.ahao.java.music.controller;


import com.ahao.java.music.pojo.Collect;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.ICollectService;
import com.ahao.java.music.service.ICollectService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("collect")
public class CollectController {
    @Autowired
    private ICollectService iCollectService;


    @PostMapping("/insert")
    public Object insertCollect(Collect collect){
        JSONObject jsonObject = new JSONObject();
        collect.setCollectCreateTime(new Date());
        Integer result = iCollectService.insertCollect(collect);
        if (result!=null){
            jsonObject.put("data",new Status(200,"收藏成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"评论失败，服务器错误",null));
        return jsonObject;
    }

    @GetMapping("/selectCollectSong")
    public Object selectCollectSong(Integer consumerId){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iCollectService.selectCollectSongByConsumerId(consumerId)));
        return jsonObject;
    }

    @GetMapping("/selectCollectSongList")
    public Object selectCollectSongList(Integer consumerId){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iCollectService.selectCollectSongListByConsumerId(consumerId)));
        return jsonObject;
    }

    @PostMapping("/delete")
    public Object deleteCollect(Collect collect){
        System.out.println(collect);
        JSONObject jsonObject=new JSONObject();
        Integer integer = iCollectService.deleteCollect(collect);
        if (integer!=null){
            jsonObject.put("data",new Status(200,"取消收藏成功",null));
            return jsonObject;
        }
        return jsonObject.put("data",new Status(204,"服务器错误",null));
    }
}
