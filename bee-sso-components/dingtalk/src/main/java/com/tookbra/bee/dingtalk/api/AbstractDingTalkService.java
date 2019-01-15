package com.tookbra.bee.dingtalk.api;

import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.http.executor.HttpExecutor;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
import lombok.Data;


/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
@Data
public abstract class AbstractDingTalkService implements DingTalkService {

    private DingTalkRepository dingTalkRepository;

    private DingTalkProperties dingTalkProperties;

    private HttpExecutor httpExecutor;

    @Override
    public String getAccessToken() {
        return getAccessToken(false);
    }
}
