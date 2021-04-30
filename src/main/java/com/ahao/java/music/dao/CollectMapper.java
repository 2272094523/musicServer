package com.ahao.java.music.dao;


import com.ahao.java.music.pojo.Collect;
import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectMapper {

    Integer insertCollect(Collect collect);

    List<Song> selectCollectSong(Integer consumerId);

    List<SongList> selectCollectSongList(Integer consumerId);

    Integer deleteCollect(Collect collect);
}
