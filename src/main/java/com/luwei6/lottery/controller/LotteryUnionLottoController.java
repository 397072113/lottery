package com.luwei6.lottery.controller;

import com.alibaba.dubbo.common.json.JSONObject;
import com.luwei6.lottery.dao.LotteryUnionLottoDao;
import com.luwei6.lottery.model.LotteryCycleDto;
import com.luwei6.lottery.model.LotteryUnionLottoDto;
import com.luwei6.lottery.services.LotteryUnionLottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @RequestMapping(value = "/qryLotteryUnionLottoListByCycleCode", method = RequestMethod.POST)
    public List<LotteryUnionLottoDto> qryLotteryUnionLottoListByCycleCode(@RequestBody LotteryUnionLottoDto dto) throws Exception {
//        LotteryUnionLottoDto dto = new LotteryUnionLottoDto();
        List<LotteryUnionLottoDto> list =  lotteryUnionLottoService.qryLotteryList(dto);
        return list;
    }

    @ResponseBody
    @RequestMapping("/queryLotteryCycleList")
    public List<LotteryCycleDto> queryLotteryCycleList() throws Exception {
        List<LotteryCycleDto> list =  lotteryUnionLottoService.queryLotteryCycle(new LotteryCycleDto());
        return list;
    }

    @ResponseBody
    @RequestMapping("/drawLotter")
    public String drawLotter() throws Exception {
        lotteryUnionLottoService.drawLotter();
        return "0";
    }
}
