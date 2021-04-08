package com.ahao.java.music.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer Song_id;
    private String Song_name;
    private String Song_singerId;
    private String Song_introduction;
    private Date Song_createTime;
    private Date Song_updateTime;
    private String Song_img;
    private String Song_lyric;
    private String Song_url;

}
