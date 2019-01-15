package com.tookbra.bee.dingtalk.repository;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
@Data
public class InMemoryRepository implements DingTalkRepository {

    private volatile String accessToken;

    private volatile long expiresTime;

    private boolean autoRefresh = false;

    private Lock lock = new ReentrantLock();

    @Override
    public String getAccessToken() {
        return this.accessToken;
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
        this.accessToken = accessToken;
        this.expiresTime = 0;
    }

    @Override
    public boolean isAccessTokenExpired() {
        return System.currentTimeMillis() > this.expiresTime;
    }

    @Override
    public synchronized void updateAccessToken(String accessToken, long expiresInSeconds) {
        this.accessToken = accessToken;
        this.expiresTime = System.currentTimeMillis() + (expiresInSeconds - 200) * 1000L;
    }
}
