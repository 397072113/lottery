package com.luwei6.user.controller;

import com.luwei6.lottery.model.LotteryUnionLottoDto;
import com.luwei6.lottery.services.LotteryUnionLottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/10/26.
 */
@Controller
public class UserController {

    @RequestMapping("/helloWorld")
    public String toIndex() throws Exception {
        return "/helloWorld";
    }

    @RequestMapping("/dualColored/genDualColorLottery")
    public String genDualColorLottery() throws Exception {
        return "/dualColored/genDualColorLottery";
    }

    @RequestMapping("dualColored/queryLottery")
    public String queryLottery() throws Exception {
        return "/dualColored/queryLottery";
    }
}
