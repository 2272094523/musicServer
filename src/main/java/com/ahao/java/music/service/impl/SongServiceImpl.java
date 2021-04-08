package com.ahao.java.music.service.impl;

import com.ahao.java.music.dao.SongMapper;
import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    private SongMapper songMapper;

    @Override
    public boolean insertSong(Song song) {
        System.out.println("song2= " + song);
        return songMapper.insertSong(song)>0?true:false;
    }

    @Override
    public boolean updateSong(Song song) {
        return songMapper.updateSong(song)>0?true:false;
    }

    @Override
    public boolean deleteSong(Integer Song_id) {
        return songMapper.deleteSong(Song_id)>0?true:false;
    }

    @Override
    public List<Song> selectAllSong() {
        return songMapper.selectAllSong();
    }

    @Override
    public List<Song> fuzzySelectSongByName(String Song_name) {
        return songMapper.fuzzySelectSongByName(Song_name);
    }

    @Override
    public Song selectSongById(Integer Song_id) {
        return songMapper.selectSongById(Song_id);
    }

    @Override
    public List<Song> selectAllBySingerId(Integer Song_singerId) {
        return songMapper.selectAllSongBySingerId(Song_singerId);
    }
}
