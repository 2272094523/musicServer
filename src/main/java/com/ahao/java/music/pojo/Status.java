package com.ahao.java.music.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private Object data;
}
