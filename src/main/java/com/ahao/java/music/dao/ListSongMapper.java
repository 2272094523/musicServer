package com.ahao.java.music.dao;

import com.ahao.java.music.pojo.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListSongMapper {

    List<Song> selectSongOfListSong(Integer songListId);
}
