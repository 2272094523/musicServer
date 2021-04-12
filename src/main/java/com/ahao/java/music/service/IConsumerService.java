package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Consumer;

import java.util.List;

public interface IConsumerService {
    List<Consumer>  selectAllConsumer();

    Integer selectTotals();
}
