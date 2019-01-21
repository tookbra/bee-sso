package com.tookbra.bee.dingtalk.api;

import com.tookbra.bee.dingtalk.bean.DingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
public interface DingTalkService {

    String GET_TOKEN_URL = "https://oapi.dingtalk.com/gettoken";

    /**
     *
     * @return
     */
    String getAccessToken();

    /**
     *
     * @param refresh
     * @return
     */
    String getAccessToken(boolean refresh);

    /**
     *
     * @param url
     * @param input
     * @param <T>
     * @return
     */
    <T extends DingTalkOutput>T get(String url, DingTalkInput<T> input);

    /**
     *
     * @param url
     * @param input
     * @param <T>
     * @return
     */
    <T extends DingTalkOutput>T post(String url, DingTalkInput<T> input);
}
