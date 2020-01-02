package com.luwei6.lottery.dao;

import com.luwei6.lottery.model.LotteryUnionLottoDto;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface LotteryUnionLottoDao {
    int findNextLuckyNumberId();

    int deleteByPrimaryKey(Integer luckyNumberId);

    int insert(LotteryUnionLottoDto record);


    int insertSelective(LotteryUnionLottoDto record);

    List<LotteryUnionLottoDto> selectByDto(LotteryUnionLottoDto dto);


    int updateByPrimaryKeySelective(LotteryUnionLottoDto record);

    int updateByPrimaryKey(LotteryUnionLottoDto record);
}