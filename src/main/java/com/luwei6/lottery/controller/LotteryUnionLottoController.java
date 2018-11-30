package com.luwei6.lottery.controller;

import com.luwei6.lottery.dao.LotteryUnionLottoDao;
import com.luwei6.lottery.model.LotteryUnionLottoDto;
import com.luwei6.lottery.services.LotteryUnionLottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/10/26.
 */
@RestController
public class LotteryUnionLottoController {

    @Autowired
    private LotteryUnionLottoService lotteryUnionLottoService;

    @ResponseBody
    @RequestMapping("/genLotteryUnionLottoList")
    public List<LotteryUnionLottoDto> genLotteryUnionLottoList() throws Exception {
        List<LotteryUnionLottoDto> list =  lotteryUnionLottoService.generateUnionLottoList();
        return list;
    }
}
