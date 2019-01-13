package com.tookbra.bee.dingtalk.repository;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
public class RedisRepository extends InMemoryRepository {

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public void expireAccessToken() {

    }
}
