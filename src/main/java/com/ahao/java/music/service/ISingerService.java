package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Singer;

import java.util.List;

public interface ISingerService {



    public List<Singer> fuzzyQuerySingerByName(String Singer_name);

    public List<Singer> selectAllSinger();

    public List<Singer> selectAllSingerBySex(Byte Singer_sex);

    public boolean insertSinger(Singer singer);

    public boolean deleteSinger(Integer Singer_id);

    public boolean updateSinger(Singer singer);

    public Singer selectSingerById(Integer Singer_id);

}
