package com.tookbra.bee.dingtalk.http.executor;

import com.tookbra.bee.dingtalk.bean.DingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
public interface HttpExecutor {


    /**
     * http post
     * @param input
     * @return
     */
    <T extends DingTalkOutput>T post(DingTalkInput<T> input);

    /**
     * http get
     * @param input
     * @return
     */
    <T extends DingTalkOutput>T get(DingTalkInput<T> input);

}
