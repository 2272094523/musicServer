package com.ahao.java.music.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


/**
 * @author 22720
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer adminID;
    private String adminName;
    private String adminPassword;



}

