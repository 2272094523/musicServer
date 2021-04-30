package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Comment;

import java.util.List;

public interface ICommentService {

    Integer insertComment(Comment comment);
    List<Comment> selectCommentBySongId(Integer songId);
    List<Comment> selectCommentBySongListId(Integer songListId);
}
