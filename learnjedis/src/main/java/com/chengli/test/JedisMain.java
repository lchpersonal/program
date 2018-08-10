package com.chengli.test;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: chengli
 * @Date: 2018/8/9 14:05
 */
public class JedisMain {


    private static final String MASTER_NAME = "mymaster";

    public static void main(String[] args) {
        JedisSentinelPool jedisSentinelPool = createJedisSentinelPool();
        long cur = System.currentTimeMillis();
        Jedis jedis = jedisSentinelPool.getResource();
        while (true) {
            try {
                String timestr = String.valueOf(System.currentTimeMillis());
                int len = timestr.length();
                System.out.println(jedis.get("name") + timestr.substring(len - 5, len));
                Thread.sleep(500);
            } catch (Exception e) {
                jedis.close();
                System.out.println("报错了" + e.getMessage());
                try {
                    while (true) {
                        jedis = jedisSentinelPool.getResource();
                        Thread.sleep(700);
                    }
                } catch (Exception e1) {
                    System.out.println("重连报错：" + e1.getMessage());
                }
            }
        }
        //System.out.println("time cast : " + (System.currentTimeMillis() - cur));
    }

    private static JedisSentinelPool createJedisSentinelPool() {
        Set<String> set = new HashSet() {
            {
                add("192.168.159.128:26379");
            }
        };
        GenericObjectPoolConfig gPoolConfig = new GenericObjectPoolConfig();
        gPoolConfig.setMaxIdle(10);
        gPoolConfig.setMaxTotal(10);
        gPoolConfig.setMaxWaitMillis(10);
        gPoolConfig.setJmxEnabled(true);
        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(MASTER_NAME, set, gPoolConfig);
        return jedisSentinelPool;
    }

}
