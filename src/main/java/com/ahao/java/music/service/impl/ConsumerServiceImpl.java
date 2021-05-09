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
    public Consumer verifyPassword(Consumer consumer) {
        return consumerMapper.verifyPassword(consumer);
    }
    @Override
    public boolean getEmailIsExist(String consumerEmail) {
        return consumerMapper.getEmailIsExist(consumerEmail)==null?false:true;
    }

    @Override
    public List<Consumer> selectAllConsumer() {
        return consumerMapper.selectAllConsumer();
    }

    @Override
    public Integer selectTotals() {
        return  consumerMapper.selectTotals();
    }

    @Override
    public boolean selectConsumerIsExist(String consumerUserName) {
        return consumerMapper.selectConsumerIsExist(consumerUserName)==null?false:true;
    }

    @Override
    public Integer insertConsumer(Consumer consumer) {
        return consumerMapper.insertConsumer(consumer);
    }

    @Override
    public Integer changeInformation(Consumer consumer) {
        return consumerMapper.changeInformation(consumer);
    }
}
