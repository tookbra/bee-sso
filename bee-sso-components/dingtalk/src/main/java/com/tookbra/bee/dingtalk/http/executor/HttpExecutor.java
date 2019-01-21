package com.tookbra.bee.dingtalk.http.executor;

import com.tookbra.bee.dingtalk.bean.DingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import com.tookbra.bee.dingtalk.http.HttpClient;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
public interface HttpExecutor {

    /**
     *
     * @return
     */
    HttpClient getHttpClient();


    /**
     * http post
     * @param input
     * @return
     */
    <T extends DingTalkOutput>T post(String url, DingTalkInput<T> input);

    /**
     * http get
     * @param input
     * @return
     */
    <T extends DingTalkOutput>T get(String url, DingTalkInput<T> input);

}
