package com.tookbra.bee.dingtalk.api;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
public interface DingTalkService {

    String GET_TOKEN_URL = "https://oapi.dingtalk.com/gettoken";

    String getAccessToken();

    String getAccessToken(boolean refresh);

}
