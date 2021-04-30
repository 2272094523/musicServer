package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Collect;
import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.SongList;

import java.util.List;

public interface ICollectService {
    Integer insertCollect(Collect collect);

    List<Song> selectCollectSongByConsumerId(Integer consumerId);

    List<SongList> selectCollectSongListByConsumerId(Integer consumerId);

    Integer deleteCollect(Collect collect);
}
