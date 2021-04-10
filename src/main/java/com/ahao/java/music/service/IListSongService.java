package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Song;

import java.util.List;

/**
 * @author 22720
 */
public interface IListSongService {
    List<Song> selectSongOfListSong(Integer songListId);
}
