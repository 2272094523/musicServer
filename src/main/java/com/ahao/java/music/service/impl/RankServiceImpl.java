package com.ahao.java.music.service.impl;

import com.ahao.java.music.dao.RankMapper;
import com.ahao.java.music.pojo.Rank;
import com.ahao.java.music.service.IRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RankServiceImpl implements IRankService {

    @Autowired
    private RankMapper rankMapper;

    @Override
    public Integer insertRank(Rank rank) {
        return rankMapper.insertRank(rank);
    }

    @Override
    public Double selectRankAvgScore(Integer rankSongListId) {
        return rankMapper.selectRankAvgScore(rankSongListId);
    }

    @Override
    public Integer selectRankTotalScore(Integer rankSongListId) {
        return rankMapper.selectRankTotalScore(rankSongListId);
    }
}
