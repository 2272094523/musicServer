package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Song;

import java.util.List;

public interface ISongService {

    public boolean insertSong(Song song);

    public boolean updateSong(Song song);

    public boolean deleteSong(Integer Song_id);

    public List<Song> selectAllSong();

    public List<Song> fuzzySelectSongByName(String Song_name);

    public Song selectSongById(Integer Song_id);

    public List<Song> selectAllBySingerId(Integer Song_singerId);
}
