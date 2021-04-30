package com.ahao.java.music.dao;


import com.ahao.java.music.pojo.Rank;
import org.springframework.stereotype.Repository;

@Repository
public interface RankMapper {

    Integer insertRank(Rank rank);

    Double selectRankAvgScore(Integer rankSongListId);

    Integer selectRankTotalScore(Integer rankSongListId);
}
