package com.ahao.java.music.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collect implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer collectId;
    private Consumer consumer;
    private Integer collectType;
    private Integer collectBeCollectId;
    private Date collectCreateTime;

}
