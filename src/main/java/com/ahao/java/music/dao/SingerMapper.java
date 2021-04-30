package com.ahao.java.music.dao;


import com.ahao.java.music.pojo.Singer;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Repository;
import sun.util.resources.cldr.ig.CalendarData_ig_NG;

import java.util.List;

@Repository
public interface SingerMapper {

    public int insertSinger(Singer singer);

    public int updateSinger(Singer singer);

    public int deleteSinger(Integer singerId);

    public Singer selectSingerByName(String singerName);

    public List<Singer> selectAllSinger();

    public List<Singer> fuzzySelectSingerByName(String singerName);

    public List<Singer> selectAllSingerBySex(Byte singerSex);

    public Singer selectSingerById(Integer singerId);



    Integer selectTotals();
}
