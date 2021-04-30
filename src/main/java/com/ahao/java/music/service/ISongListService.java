package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.SongList;

import java.util.List;

public interface ISongListService {

    public boolean insertSongList(SongList songList);

    public boolean updateSongList(SongList songList);

    public boolean deleteSongList(Integer songListId);

    public List<SongList> selectAllSongList();

    public List<SongList> fuzzySelectSongListByTitle(String songListTitle);

    public SongList selectSongListById(Integer songListId);

    public List<SongList> selectSongListByStyle(String songListStyle);

    Integer selectTotals();

    Integer styleIsExist(String style);

    List<String> getSongStyle();
}
