package com.ahao.java.music.dao;

import com.ahao.java.music.pojo.Song;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListSongMapper {

    List<Song> selectSongOfListSong(Integer songListId);

    Integer deleteSongFromListSong(@Param("songId") Integer songId,@Param("songListId") Integer songListId);

    Integer insertSongToListSong(@Param("songId")Integer songId, @Param("songListId")Integer songListId);
}
