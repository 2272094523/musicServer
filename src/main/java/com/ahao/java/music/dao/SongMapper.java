package com.ahao.java.music.dao;


import com.ahao.java.music.pojo.Song;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongMapper {

    public int insertSong(Song song);

    public int updateSong(Song song);

    public int deleteSong(Integer songId);

    public List<Song> selectAllSong();

    public List<Song> fuzzySelectSongByName(String songName);

    public Song selectSongById(Integer songId);

    public List<Song> selectAllSongBySingerId(Integer singerId);


    List<Song> selectSongNoInCurrentList(Integer songListId);
}
