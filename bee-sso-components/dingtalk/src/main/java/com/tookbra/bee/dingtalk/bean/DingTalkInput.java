package com.tookbra.bee.dingtalk.bean;

import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;

import java.util.Map;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
public interface DingTalkInput<T extends DingTalkOutput> {

    /**
     *
     */
    Class<T> getClasses();

    /**
     *
     * @return
     */
    String getParam();

    /**
     *
     * @return
     */
    String getUrl();

    /**
     *
     * @return
     */
    Map<String, String> toMap();

}
