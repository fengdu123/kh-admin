package com.kh.admin.service;

import redis.clients.jedis.Jedis;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:
 * @Date: Created in 10:55 2017/6/14
 */
public class RedisStringJava {

    public static void main(String[] args){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "Redis tutorial");
        // 获取存储的数据并输出
        System.out.println("Stored string in redis:: "+ jedis.get("runoobkey"));
    }
}
