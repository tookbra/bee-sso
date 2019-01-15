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
     *
     * @param input
     * @param <T>
     * @return
     */
    public <T extends DingTalkOutput>T post(DingTalkInput<T> input);

    /**
     *
     * @param input
     * @param <T>
     * @return
     */
    public <T extends DingTalkOutput>T get(DingTalkInput<T> input);

}
