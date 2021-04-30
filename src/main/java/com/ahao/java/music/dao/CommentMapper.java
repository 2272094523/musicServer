package com.ahao.java.music.dao;


import com.ahao.java.music.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    List<Comment> selectCommentBySongId(Integer songId);
    List<Comment> selectCommentBySongListId(Integer songListId);
    Integer insertComment(Comment comment);
}
