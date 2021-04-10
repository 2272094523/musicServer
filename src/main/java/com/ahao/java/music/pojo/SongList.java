package com.ahao.java.music.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongList implements Serializable {

    private Integer songListId;
    private String songListTitle;
    private String songListImg;
    private String songListIntroduction;
    private String songListStyle;


}
