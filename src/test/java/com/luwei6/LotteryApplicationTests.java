package com.luwei6;

import com.luwei6.lottery.cache.RedisCacheServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LotteryApplicationTests {

	@Autowired
	private RedisCacheServices redisCacheServices;
	@Test
	public void contextLoads() {
//		redisCacheServices.setLotteryConfig();
		Map<String, Object> map = redisCacheServices.getLotteryConfig("lotteryConfig1");
		System.out.print("++++++++++++++++++++++++++++"+ map);
	}

}
