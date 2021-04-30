package com.ahao.java.music.service.impl;

import com.ahao.java.music.dao.CommentMapper;
import com.ahao.java.music.pojo.Comment;
import com.ahao.java.music.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements ICommentService {


    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Integer insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public List<Comment> selectCommentBySongId(Integer songId) {
        return commentMapper.selectCommentBySongId(songId);
    }

    @Override
    public List<Comment> selectCommentBySongListId(Integer songListId) {
        return commentMapper.selectCommentBySongListId(songListId);
    }
}
