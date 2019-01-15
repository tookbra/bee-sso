package com.tookbra.bee.dingtalk.api.impl;

import com.tookbra.bee.dingtalk.api.AbstractDingTalkService;
import com.tookbra.bee.dingtalk.bean.input.GetTokenInput;
import com.tookbra.bee.dingtalk.bean.output.token.TokenOutput;

import java.io.IOException;
import java.util.concurrent.locks.Lock;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
public class DingTalkServiceImpl extends AbstractDingTalkService {


    public DingTalkServiceImpl() {

    }


    @Override
    public String getAccessToken(boolean refresh) {
        Lock lock = this.getDingTalkRepository().getLock();
        try {
            lock.lock();
            if (this.getDingTalkRepository().isAccessTokenExpired() || refresh) {
                String url = String.format(GET_TOKEN_URL, this.getDingTalkProperties().getAppKey(),
                        this.getDingTalkProperties().getAppSecret());
                GetTokenInput input = new GetTokenInput();
                TokenOutput tokenOutput = super.getHttpExecutor().get(input);
                this.getDingTalkRepository().updateAccessToken(tokenOutput.getAccessToken(), tokenOutput.getExpiresIn());
            }
        }finally {
            lock.unlock();
        }

        return this.getDingTalkRepository().getAccessToken();
    }
}
