package com.tookbra.bee.dingtalk.repository;

import java.util.concurrent.locks.Lock;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
public interface DingTalkRepository {

    /**
     * 获取锁
     * @return
     */
    Lock getLock();

    /**
     * 获取token
     * @return
     */
    String getAccessToken();

    /**
     * 移除token
     */
    void expireAccessToken();

    /**
     * 是否自动刷新token
     * @return true or false
     */
    boolean autoRefreshToken();

    /**
     * 更新token
     * @param accessToken token
     */
    void updateToken(String accessToken);

    /**
     * token是否过期
     * @return true or false
     */
    boolean isAccessTokenExpired();

    /**
     * 更新凭证
     * @param accessToken
     * @param expiresInSeconds
     */
    void updateAccessToken(String accessToken, long expiresInSeconds);

}
