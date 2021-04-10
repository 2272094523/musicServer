package com.ahao.java.music.controller;


import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.IListSongService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/listsong")
@RestController
public class ListSongController {

    @Autowired
    private IListSongService iListSongService;

    @RequestMapping(value = "/selectSongOfListSong",method = RequestMethod.GET)
    public Object selectSongOfListSong(Integer songListId){
        JSONObject jsonObject = new JSONObject();
        List<Song> list = iListSongService.selectSongOfListSong(songListId);
        jsonObject.put("data",new Status(200,"查询成功",list));
        return jsonObject;
    }

    @RequestMapping(value ="/deleteSong",method = RequestMethod.POST)
    public Object deleteSongFromListSong(@RequestParam("songId")Integer songId,@RequestParam("songListId")Integer songListId){
        JSONObject jsonObject=new JSONObject();
        Integer result = iListSongService.deleteSongFromListSong(songId, songListId);
        if (result>0){
            jsonObject.put("data",new Status(200,"删除成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"删除失败，请确认该歌单中当前歌曲存在",null));
        return jsonObject;
    }
    @RequestMapping(value = "/insertSongToList",method = RequestMethod.POST)
    public Object insertSongToListSong(@RequestParam("songId")Integer songId,@RequestParam("songListId")Integer songListId){
        JSONObject jsonObject = new JSONObject();
        boolean result=iListSongService.insertSongToListSong(songId,songListId);
        if (result){
            jsonObject.put("data",new Status(200,"添加成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(200,"添加失败",null));
        return jsonObject;

    }
}
