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
    public boolean deleteSong(Integer songId) {
        return songMapper.deleteSong(songId)>0?true:false;
    }

    @Override
    public List<Song> selectAllSong() {
        return songMapper.selectAllSong();
    }

    @Override
    public List<Song> fuzzySelectSongByName(String songName) {
        return songMapper.fuzzySelectSongByName(songName);
    }

    @Override
    public Song selectSongById(Integer Song_id) {
        return songMapper.selectSongById(Song_id);
    }

    @Override
    public Integer selectTotals() {
        return songMapper.selectTotals();
    }

    @Override
    public List<Song> selectAllBySingerId(Integer singerId) {
        return songMapper.selectAllSongBySingerId(singerId);
    }

    @Override
    public List<Song> selectSongNoInCurrentList(Integer songListId) {
        return songMapper.selectSongNoInCurrentList(songListId);
    }


}
