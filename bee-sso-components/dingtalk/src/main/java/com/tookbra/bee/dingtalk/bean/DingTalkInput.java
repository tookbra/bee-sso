package com.tookbra.bee.dingtalk.bean;

import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
public interface DingTalkInput<T extends DingTalkOutput> {

    /**
     *
     */
    public Class<T> getClasses();

    /**
     *
     * @return
     */
    public String getParam();


}
