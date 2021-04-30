package com.ahao.java.music.service.impl;


import com.ahao.java.music.dao.CollectMapper;
import com.ahao.java.music.pojo.Collect;
import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.SongList;
import com.ahao.java.music.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl  implements ICollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public Integer insertCollect(Collect collect) {
        return  collectMapper.insertCollect(collect);
    }

    @Override
    public List<Song> selectCollectSongByConsumerId(Integer consumerId) {
        return collectMapper.selectCollectSong(consumerId);
    }

    @Override
    public List<SongList> selectCollectSongListByConsumerId(Integer consumerId) {
        return collectMapper.selectCollectSongList(consumerId);
    }

    @Override
    public Integer deleteCollect(Collect collect) {
        return collectMapper.deleteCollect(collect);
    }
}
