package com.ahao.java.music.controller;

import com.ahao.java.music.config.BaseControllerStringToDate;
import com.ahao.java.music.pojo.Comment;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.ICommentService;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/comment")
public class CommentController extends BaseControllerStringToDate {


    @Autowired
    private ICommentService iCommentService;


    @PostMapping("/insert")
    public Object insertComment(Comment comment){
        JSONObject jsonObject = new JSONObject();
        comment.setCommentCreateTime(new Date());
        Integer result = iCommentService.insertComment(comment);
        if (result!=null){
            jsonObject.put("data",new Status(200,"评论成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"评论失败，服务器错误",null));
        return jsonObject;
    }

    @GetMapping("/selectCommentBySongId")
    public Object selectCommentBySongId(Integer songId){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iCommentService.selectCommentBySongId(songId)));
        return jsonObject;
    }

    @GetMapping("/selectCommentBySongListId")
    public Object selectCommentBySongListId(Integer songListId){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iCommentService.selectCommentBySongListId(songListId)));
        return jsonObject;
    }




}
