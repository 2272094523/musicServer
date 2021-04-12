package com.ahao.java.music.dao;


import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongListMapper {

    public int insertSongList(SongList songList);

    public int updateSongList(SongList songList);

    public int deleteSongList(Integer songListId);

    public List<SongList> selectAllSongList();

    public List<SongList> fuzzySelectSongListByTitle(String songListTitle);

    public SongList selectSongListById(Integer songListId);

    public SongList selectSongListByStyle(String songListStyle);


    Integer selectTotals();
}
