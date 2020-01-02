package com.luwei6.lottery.dao;

import com.luwei6.lottery.model.LotteryCycleDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotteryCycleDtoMapper {

    int deleteByPrimaryKey(String cycleCode);

    int insert(LotteryCycleDto record);

    int insertSelective(LotteryCycleDto record);

    LotteryCycleDto selectByPrimaryKey(String cycleCode);

    List<LotteryCycleDto> selectAllLotteryCycle(LotteryCycleDto dto);

    LotteryCycleDto selectCurrentLotteryCycle(LotteryCycleDto dto);

    int updateByPrimaryKeySelective(LotteryCycleDto record);

    int updateByPrimaryKey(LotteryCycleDto record);
}