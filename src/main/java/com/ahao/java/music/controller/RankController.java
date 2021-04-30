package com.ahao.java.music.controller;


import com.ahao.java.music.pojo.Rank;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.IRankService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rank")
public class RankController {
    @Autowired
    private IRankService iRankService;

    @RequestMapping("/insert")
    public Object insertRank(Rank rank){
        System.out.println(rank);
        JSONObject jsonObject = new JSONObject();
        try {
            Integer result=iRankService.insertRank(rank);
            if (result!=null){
                jsonObject.put("data",new Status(200,"打分成功",null));
                return jsonObject;
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",new Status(204,"打分失败，已经对其打过分",null));
            return jsonObject;
        }
        return null;
    }
    @RequestMapping("selectAvgScore")
    public Object selectRankAvgScore(Integer rankSongListId){
        JSONObject jsonObject = new JSONObject();
        Double result=iRankService.selectRankAvgScore(rankSongListId);
        if (result!=null){
            jsonObject.put("data",new Status(200,"查询成功",result));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"查询失败",null));
        return jsonObject;
    }

    @RequestMapping
    public Object selectRankTotalScore(Integer rankSongListId){
        JSONObject jsonObject = new JSONObject();
        Integer result=iRankService.selectRankTotalScore(rankSongListId);
        System.out.println(result);
        if (result!=null){
            jsonObject.put("data",new Status(200,"查询成功",result));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"查询失败",null));
        return jsonObject;
    }

}
