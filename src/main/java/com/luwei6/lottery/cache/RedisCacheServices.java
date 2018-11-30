package com.luwei6.lottery.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Administrator on 2018/10/30.
 */
@Component
public class RedisCacheServices {

    @Autowired
    private RedisTemplate redisTemplate;

    private HashOperations<String,String,Object> opsForHash = null;

    private HashOperations<String,String,Object> getOpsForHash() {
        if(opsForHash == null) {
            opsForHash = redisTemplate.opsForHash();
        }
        return opsForHash;
    }
    /**
     * 查询hash数据
     * @param key
     * @return
     */
    public Map<String, Object> getLotteryConfig(String key) {
        return getOpsForHash().entries("lotteryConfig1");
    }

    public boolean hasKey(String key) {
        return getOpsForHash().hasKey(key,"lotteryDate");
    }

    /**
     * redis 插入Hash数据
     * @param key
     * @param map
     */
    public void setLotteryConfig(String key, Map<String,Object> map) {
//        Map<String,Object> configMap = new HashMap<String,Object>();
//        configMap.put("lotteryPeriod",2018126);
//        configMap.put("lotteryDate","20181028");
//        configMap.put("lotteryRedNum1","01");
//        configMap.put("lotteryRedNum2","06");
//        configMap.put("lotteryRedNum3","08");
//        configMap.put("lotteryRedNum4","09");
//        configMap.put("lotteryRedNum5","19");
//        configMap.put("lotteryRedNum6","22");
//        configMap.put("lotteryBlueNum","05");
        getOpsForHash().putAll(key ,map);
    }

    /**
     * 根据key值删除redis数据
     * @param key
     */
    public void deleteKey(String key) {
        getOpsForHash().delete("key");
    }
}
