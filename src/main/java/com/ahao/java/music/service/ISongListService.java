package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.SongList;

import java.util.List;

public interface ISongListService {

    public boolean insertSongList(SongList songList);

    public boolean updateSongList(SongList songList);

    public boolean deleteSongList(Integer SongList_id);

    public List<SongList> selectAllSongList();

    public List<SongList> fuzzySelectSongListByTitle(String SongList_title);

    public SongList selectSongListById(Integer SongList_id);

    public SongList selectSongListByStyle(String SongList_style);
}
