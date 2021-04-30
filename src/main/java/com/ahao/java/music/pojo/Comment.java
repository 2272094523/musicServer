package com.ahao.java.music.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer commentId;
    private Consumer consumer;
    private Integer commentType;
    private Integer commentBeWriteId;
    private String commentContent;
    private Date commentCreateTime;
}
