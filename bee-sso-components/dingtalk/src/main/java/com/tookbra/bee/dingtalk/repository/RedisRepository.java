package com.tookbra.bee.dingtalk.repository;

import com.tookbra.bee.dingtalk.enums.RepositoryEnum;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
public class RedisRepository extends InMemoryRepository {

    private JedisPool jedisPool;

    public RedisRepository() {}

    public RedisRepository(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    private static final String TOKEN_KEY = "dingtalk:token";

    @Override
    public String getAccessToken() {
        try(Jedis jedis = jedisPool.getResource()) {
            return jedis.get(TOKEN_KEY);
        }
    }

    @Override
    public void expireAccessToken() {
        try (Jedis jedis = this.jedisPool.getResource()) {
            jedis.expire(TOKEN_KEY, 0);
        }
    }

    @Override
    public boolean isAccessTokenExpired() {
        try (Jedis jedis = this.jedisPool.getResource()) {
            return jedis.ttl(TOKEN_KEY) < 2;
        }
    }

    @Override
    public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
        try (Jedis jedis = this.jedisPool.getResource()) {
            jedis.setex(TOKEN_KEY, expiresInSeconds - 200, accessToken);
        }
    }

    @Override
    public String getName() {
        return RepositoryEnum.REDIS.name();
    }
}
