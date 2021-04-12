package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Song;

import java.util.List;

public interface ISongService {

    public boolean insertSong(Song song);

    public boolean updateSong(Song song);

    public boolean deleteSong(Integer songId);

    public List<Song> selectAllSong();

    public List<Song> fuzzySelectSongByName(String songName);

    public Song selectSongById(Integer Song_id);

    public List<Song> selectAllBySingerId(Integer singerId);

    List<Song> selectSongNoInCurrentList(Integer songListId);

    Integer selectTotals();
}
