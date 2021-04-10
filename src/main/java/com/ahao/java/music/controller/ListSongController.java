package com.ahao.java.music.controller;


import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.IListSongService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/listsong")
@RestController
public class ListSongController {

    @Autowired
    private IListSongService iListSongService;

    @RequestMapping(value = "/selectSongOfListSong",method = RequestMethod.GET)
    public Object selectSongOfListSong(Integer songListId){
        System.out.println("songListId = " + songListId);
        JSONObject jsonObject = new JSONObject();
        List<Song> list = iListSongService.selectSongOfListSong(songListId);
        jsonObject.put("data",new Status(200,"查询成功",list));
        return jsonObject;
    }
}
