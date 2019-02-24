package com.tookbra.bee.dingtalk.api;

import com.tookbra.bee.dingtalk.api.AbstractDingTalkService;
import com.tookbra.bee.dingtalk.bean.input.GetTokenInput;
import com.tookbra.bee.dingtalk.bean.output.token.TokenOutput;
import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.http.HttpClient;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
import com.tookbra.bee.sso.core.utils.JackSonUtil;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.locks.Lock;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
@Slf4j
@EqualsAndHashCode(callSuper = false)
public class DingTalkServiceImpl extends AbstractDingTalkService {

    private DingTalkProperties dingTalkProperties;

    public DingTalkServiceImpl(HttpClient httpClient,
                               DingTalkProperties dingTalkProperties,
                               DingTalkRepository dingTalkRepository) {
        super(httpClient, dingTalkProperties.getHttpConfig(), dingTalkRepository);
        this.dingTalkProperties = dingTalkProperties;
    }

    @Override
    public String getAccessToken(boolean refresh) {
        Lock lock = this.getDingTalkRepository().getLock();
        try {
            lock.lock();
            if (super.getDingTalkRepository().isAccessTokenExpired() || refresh) {
                GetTokenInput input = new GetTokenInput();
                input.setAppKey(this.dingTalkProperties.getAppKey());
                input.setAppSecret(this.dingTalkProperties.getAppSecret());
                String result = super.getHttpClient().get(GET_TOKEN_URL,input.toMap());
                TokenOutput tokenOutput = JackSonUtil.objectMapper.readValue(result, TokenOutput.class);
                this.getDingTalkRepository().updateAccessToken(tokenOutput.getAccessToken(), tokenOutput.getExpiresIn());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return this.getDingTalkRepository().getAccessToken();
    }

    @Override
    public String getAccessToken() {
        return getAccessToken(false);
    }
}
