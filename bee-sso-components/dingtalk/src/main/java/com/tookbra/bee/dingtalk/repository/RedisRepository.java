package com.tookbra.bee.dingtalk.repository;

import redis.clients.jedis.JedisPool;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
public class RedisRepository extends InMemoryRepository {

    private JedisPool jedisPool;

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public void expireAccessToken() {

    }
}
