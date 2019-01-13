package com.tookbra.bee.dingtalk.repository;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
public class InMemoryRepository implements DingTalkRepository {

    private volatile String token;

    private volatile long expiresTime;

    private boolean autoRefresh = false;

    @Override
    public String getAccessToken() {
        return this.token;
    }

    @Override
    public void expireAccessToken() {
        this.expiresTime = 0;
    }

    @Override
    public boolean autoRefreshToken() {
        return this.autoRefresh;
    }

    @Override
    public void updateToken(String accessToken) {
        this.token = accessToken;
        this.expiresTime = 0;
    }
}
