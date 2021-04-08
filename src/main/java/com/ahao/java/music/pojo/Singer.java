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
    private Integer Singer_id;
    private String Singer_name;
    private Byte Singer_sex;
    private String Singer_img;
    private Date Singer_birth;
    private String Singer_location;
    private String Singer_introduction;

}
