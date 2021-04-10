package com.ahao.java.music.service.impl;

import com.ahao.java.music.controller.SingerController;
import com.ahao.java.music.dao.SingerMapper;
import com.ahao.java.music.pojo.Singer;
import com.ahao.java.music.service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;


@Service
public class SingerServiceImpl implements ISingerService {


    @Autowired
    private SingerMapper singerMapper;

    @Override
    public boolean insertSinger(Singer singer) {
        return singerMapper.insertSinger(singer)>0?true:false;
    }

    @Override
    public boolean deleteSinger(Integer singerId) {
        return singerMapper.deleteSinger(singerId)>0?true:false;
    }

    @Override
    public boolean updateSinger(Singer singer) {
        return singerMapper.updateSinger(singer)>0?true:false;
    }

    @Override
    public List<Singer> fuzzyQuerySingerByName(String singerName) {
        return singerMapper.fuzzySelectSingerByName(singerName);
    }

    @Override
    public Singer selectSingerById(Integer singerId) {
        return singerMapper.selectSingerById(singerId);
    }

    @Override
    public List<Singer> selectAllSinger() {
        return singerMapper.selectAllSinger();
    }

    @Override
    public List<Singer> selectAllSingerBySex(Byte singerSex) {
        return singerMapper.selectAllSingerBySex(singerSex);
    }


}
