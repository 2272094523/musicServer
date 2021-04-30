package com.ahao.java.music.service;

import com.ahao.java.music.pojo.Rank;

public interface IRankService {

    Integer insertRank(Rank rank);

    Double selectRankAvgScore(Integer rankSongListId);

    Integer selectRankTotalScore(Integer rankSongListId);
}
