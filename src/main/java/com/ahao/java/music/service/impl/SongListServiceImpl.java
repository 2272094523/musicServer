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
    public boolean insertSongList(SongList songList) {
        return songListMapper.insertSongList(songList)>0?true:false;

    }

    @Override
    public boolean updateSongList(SongList songList) {
        return songListMapper.updateSongList(songList)>0?true:false;
    }

    @Override
    public boolean deleteSongList(Integer SongList_id) {
        return songListMapper.deleteSongList(SongList_id)>0?true:false;
    }

    @Override
    public List<SongList> selectAllSongList() {
        return songListMapper.selectAllSongList();
    }

    @Override
    public List<SongList> fuzzySelectSongListByTitle(String SongList_title) {
        return songListMapper.fuzzySelectSongListByTitle(SongList_title);
    }

    @Override
    public SongList selectSongListById(Integer SongList_id) {
        return songListMapper.selectSongListById(SongList_id);
    }

    @Override
    public SongList selectSongListByStyle(String SongList_style) {
        return songListMapper.selectSongListByStyle(SongList_style);
    }

}
