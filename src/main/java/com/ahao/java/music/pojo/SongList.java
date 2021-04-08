package com.ahao.java.music.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongList implements Serializable {

    private Integer SongList_id;
    private String SongList_title;
    private String SongList_img;
    private String SongList_introduction;
    private String SongList_style;


}
