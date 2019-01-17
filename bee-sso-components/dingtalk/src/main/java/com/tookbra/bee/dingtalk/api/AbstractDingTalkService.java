package com.tookbra.bee.dingtalk.api;

import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.http.HttpClient;
import com.tookbra.bee.dingtalk.http.executor.DefaultHttpExecutor;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;


/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
public abstract class AbstractDingTalkService extends DefaultHttpExecutor {


    public AbstractDingTalkService(HttpClient httpClient,
                                   DingTalkProperties.HttpConfig httpConfig,
                                   DingTalkRepository dingTalkRepository) {
        super(httpClient, httpConfig, dingTalkRepository);
    }
}
