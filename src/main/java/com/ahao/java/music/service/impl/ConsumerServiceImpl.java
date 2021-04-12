package com.ahao.java.music.service.impl;

import com.ahao.java.music.dao.ConsumerMapper;
import com.ahao.java.music.pojo.Consumer;
import com.ahao.java.music.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22720
 */

@Service
public class ConsumerServiceImpl implements IConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public List<Consumer> selectAllConsumer() {
        return consumerMapper.selectAllConsumer();
    }

    @Override
    public Integer selectTotals() {
        return  consumerMapper.selectTotals();
    }
}
