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
    private Integer songId;
    private String songName;
    private String songIntroduction;
    private Date songCreateTime;
    private Date songUpdateTime;
    private String songImg;
    private String songLyric;
    private String songUrl;
    private Singer singer;
}
