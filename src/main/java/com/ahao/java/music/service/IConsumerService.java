package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Consumer;

import java.util.List;

public interface IConsumerService {
    List<Consumer>  selectAllConsumer();

    Integer selectTotals();

    boolean selectConsumerIsExist(String consumerUserName);

    Integer insertConsumer(Consumer consumer);

    boolean getEmailIsExist(String consumerEmail);

    Consumer verifyPassword(Consumer consumer);
}
