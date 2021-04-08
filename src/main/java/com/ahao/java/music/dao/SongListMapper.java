package com.ahao.java.music.dao;


import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongListMapper {

    public int insertSongList(SongList songList);

    public int updateSongList(SongList songList);

    public int deleteSongList(Integer SongList_id);

    public List<SongList> selectAllSongList();

    public List<SongList> fuzzySelectSongListByTitle(String SongList_title);

    public SongList selectSongListById(Integer SongList_id);

    public SongList selectSongListByStyle(String SongList_style);


}
