package com.bee.learnredis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisMain {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("jedis已开启");
        System.out.println(jedis.ping());
        //string
        String set = jedis.set("testKey", "zxl2");
        System.out.println(set);
        String testKey = jedis.get("testKey");
        System.out.println(testKey);
        //list
        jedis.lpush("testList","one");
        jedis.lpush("testList","two");
        jedis.lpush("testList","three");
        List<String> testList = jedis.lrange("testList", 0, 2);
        for (String s : testList) {
            System.out.println(s);//倒序
        }

    }
}
