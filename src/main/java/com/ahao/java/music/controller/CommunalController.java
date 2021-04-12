package com.ahao.java.music.controller;


import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author 22720
 */
@RestController
@RequestMapping("/communal")
public class CommunalController {

    @Autowired
    private IConsumerService iConsumerService;
    @Autowired
    private ISongListService iSongListService;
    @Autowired
    private ISongService iSongService;
    @Autowired
    private ISingerService iSingerService;

    @RequestMapping(value = "/selectAllTotals",method = RequestMethod.GET)
    public Object selectAllTotals(){
        JSONObject jsonObject = new JSONObject();
        HashMap<String, Object> totalMap = new HashMap<>(7);
        totalMap.put("consumerTotals",iConsumerService.selectTotals());
        totalMap.put("singerTotals",iSingerService.selectTotals());
        totalMap.put("songTotals",iSongService.selectTotals());
        totalMap.put("songListTotals",iSongListService.selectTotals());
        totalMap.put("consumerLists",iConsumerService.selectAllConsumer());
        totalMap.put("songLists",iSongService.selectAllSong());
        totalMap.put("songList_Lists",iSongListService.selectAllSongList());
        totalMap.put("singerLists",iSingerService.selectAllSinger());
        jsonObject.put("data",new Status(200,"查询成功",totalMap));
        return jsonObject;
    }

}
