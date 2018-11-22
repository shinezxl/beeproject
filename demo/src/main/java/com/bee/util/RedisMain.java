package com.bee.util;

import redis.clients.jedis.Jedis;

public class RedisMain {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("jedis已开启");
        System.out.println(jedis.ping());
        String set = jedis.set("testKey", "zxl2");
        System.out.println(set);
        String testKey = jedis.get("testKey");
        System.out.println(testKey);


    }
}
