package com.tookbra.bee.dingtalk.repository;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
public interface DingTalkRepository {

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
     */
    boolean autoRefreshToken();

    /**
     * 更新token
     * @param accessToken token
     */
    void updateToken(String accessToken);

}
