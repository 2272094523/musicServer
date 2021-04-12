package com.ahao.java.music.service.impl;

import com.ahao.java.music.dao.SongListMapper;
import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.SongList;
import com.ahao.java.music.service.ISongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongListServiceImpl implements ISongListService {
    @Autowired
    private SongListMapper songListMapper;

    @Override
    public Integer selectTotals() {
        return songListMapper.selectTotals();
    }

    @Override
    public boolean insertSongList(SongList songList) {
        return songListMapper.insertSongList(songList)>0?true:false;

    }

    @Override
    public boolean updateSongList(SongList songList) {
        return songListMapper.updateSongList(songList)>0?true:false;
    }

    @Override
    public boolean deleteSongList(Integer songListId) {
        return songListMapper.deleteSongList(songListId)>0?true:false;
    }

    @Override
    public List<SongList> selectAllSongList() {
        return songListMapper.selectAllSongList();
    }

    @Override
    public List<SongList> fuzzySelectSongListByTitle(String songListTitle) {
        return songListMapper.fuzzySelectSongListByTitle(songListTitle);
    }

    @Override
    public SongList selectSongListById(Integer songListId) {
        return songListMapper.selectSongListById(songListId);
    }

    @Override
    public SongList selectSongListByStyle(String songListStyle) {
        return songListMapper.selectSongListByStyle(songListStyle);
    }

}
