package com.ahao.java.music.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 22720
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer consumerId;
    private String consumerUserName;
    private String consumerPassword;
    private String consumerNickName;
    private Byte consumerSex;
    private String consumerEmail;
    private Date consumerBirth;
    private String consumerIntroduction;
    private String consumerLocation;
    private String consumerImg;
    private Date consumerCreateTime;
}
