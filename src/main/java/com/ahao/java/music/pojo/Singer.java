package com.ahao.java.music.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Singer implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer singerId;
    private String singerName;
    private Byte singerSex;
    private String singerImg;
    private Date singerBirth;
    private String singerLocation;
    private String singerIntroduction;
}
