package com.ahao.java.music.dao;


import com.ahao.java.music.pojo.Consumer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerMapper {
    List<Consumer> selectAllConsumer();

    Integer selectTotals();
}
