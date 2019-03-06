package com.bee.learnredis;

import com.bee.model.RankModel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://blog.csdn.net/m0_37459380/article/details/82971525
 * Redis实现排行榜功能(实战)
 */
public class RankingList {

    public static final String SCORE_RANK = "score_rank";

   /* @Autowired
    private StringRedisTemplate redisTemplate;//注入不进来，原因待查*/

    private static StringRedisTemplate redisTemplate ;
    public static StringRedisTemplate initTemplate(){
        RedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        StringRedisTemplate redisTemplate = new StringRedisTemplate(connectionFactory);
        return redisTemplate;
    }
    static {
        redisTemplate = initTemplate();
    }


    @Test
    public void batchAdd(){
        Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            DefaultTypedTuple<String> tuple = new DefaultTypedTuple<>("张三" + i,1D + i);
            tuples.add(tuple);

        }
//        StringRedisTemplate stringRedisTemplate = initTemplate();
        System.out.println("循环时间:" +( System.currentTimeMillis() - startTime));
        Long num = redisTemplate.opsForZSet().add(SCORE_RANK, tuples);
        System.out.println("批量新增时间:" +(System.currentTimeMillis() - startTime));
        System.out.println("受影响行数：" + num);
    }

    /**
     * 获取排行列表
     */
    @Test
    public void list() {
        Set<String> range = redisTemplate.opsForZSet().reverseRange(SCORE_RANK, 0, 10);
        System.out.println("获取到的排行列表:" + JSONArray.fromObject(range));
        Set<ZSetOperations.TypedTuple<String>> rangeWithScores = redisTemplate.opsForZSet().reverseRangeWithScores(SCORE_RANK, 0, 10);
        JSONArray jsonArray = JSONArray.fromObject(rangeWithScores);
        List<RankModel> list = JSONArray.toList(jsonArray, new RankModel(), new JsonConfig());
        System.out.println("获取到的排行和分数列表:" + JSONArray.fromObject(list).toString());
    }



}
