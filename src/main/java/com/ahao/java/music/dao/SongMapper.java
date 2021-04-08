package com.ahao.java.music.dao;


import com.ahao.java.music.pojo.Song;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongMapper {

    public int insertSong(Song song);

    public int updateSong(Song song);

    public int deleteSong(Integer Song_id);

    public List<Song> selectAllSong();

    public List<Song> fuzzySelectSongByName(String Song_name);

    public Song selectSongById(Integer Song_id);

    public List<Song> selectAllSongBySingerId(Integer Song_singerId);






}
