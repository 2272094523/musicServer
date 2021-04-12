package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Singer;

import java.util.List;


public interface ISingerService {

    public List<Singer> fuzzyQuerySingerByName(String singerName);

    public List<Singer> selectAllSinger();

    public List<Singer> selectAllSingerBySex(Byte singerSex);

    public boolean insertSinger(Singer singer);

    public boolean deleteSinger(Integer singerId);

    public boolean updateSinger(Singer singer);

    public Singer selectSingerById(Integer singerId);

    Integer selectTotals();

}
