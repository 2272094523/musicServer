package com.ahao.java.music.service.impl;

import com.ahao.java.music.dao.ListSongMapper;
import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.service.IListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSongServiceImpl implements IListSongService {
    @Autowired
    private ListSongMapper listSongMapper;
    @Override
    public List<Song> selectSongOfListSong(Integer songListId) {
        return listSongMapper.selectSongOfListSong(songListId);
    }

    @Override
    public Integer deleteSongFromListSong(Integer songId, Integer songListId) {
        return listSongMapper.deleteSongFromListSong(songId,songListId);
    }

    @Override
    public boolean insertSongToListSong(Integer songId, Integer songListId) {
        return listSongMapper.insertSongToListSong(songId,songListId)>0?true:false;
    }
}
