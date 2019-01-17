package com.tookbra.bee.dingtalk.http.executor;

import com.tookbra.bee.dingtalk.api.DingTalkService;
import com.tookbra.bee.dingtalk.bean.DingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.enums.DingTalkCodeEnum;
import com.tookbra.bee.dingtalk.enums.HttpMethodEnum;
import com.tookbra.bee.dingtalk.exception.DingTalkException;
import com.tookbra.bee.dingtalk.http.HttpClient;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
import com.tookbra.bee.sso.core.utils.JackSonUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
@Slf4j
@Data
public abstract class DefaultHttpExecutor implements HttpExecutor, DingTalkService {

    private HttpClient httpClient;
    private DingTalkProperties.HttpConfig httpConfig;
    private DingTalkRepository dingTalkRepository;

    public DefaultHttpExecutor(HttpClient httpClient, DingTalkProperties.HttpConfig httpConfig, DingTalkRepository dingTalkRepository) {
        this.httpClient = httpClient;
        this.httpClient.init(httpConfig, dingTalkRepository);
        this.httpConfig = httpConfig;
        this.dingTalkRepository = dingTalkRepository;
    }


    @Override
    public <T extends DingTalkOutput>T get(DingTalkInput<T> input) {
        return this.execute(input, HttpMethodEnum.GET);
    }

    @Override
    public <T extends DingTalkOutput>T post(DingTalkInput<T> input) {
        return this.execute(input, HttpMethodEnum.POST);
    }

    private <T extends DingTalkOutput>T execute(DingTalkInput<T> input, HttpMethodEnum httpMethodEnum) {
        int retryCount = 0;
        do {
            try {
                String accessToken = getAccessToken(false);
                StringBuilder sb = new StringBuilder(input.getUrl());
                String url = sb.append((input.getUrl().contains("?") ? "&" : "?") + "access_token=" + accessToken).toString();
                String result = "";
                switch (httpMethodEnum) {
                    case GET:
                        result = httpClient.get(url, input.toMap());
                        break;
                    case POST:
                        result = httpClient.post(url, input.toMap());
                        break;
                    default:
                }
                log.debug("请求地址:{}, 请求参数:{}, 请求结果:{}", input.getUrl(), input.getParam(), result);
                return JackSonUtil.objectMapper.convertValue(result, input.getClasses());
            } catch (DingTalkException exception) {
                if (exception.getErrorCode().equals(DingTalkCodeEnum.TOKEN_ERROR.getCode())
                        || exception.getErrorCode().equals(DingTalkCodeEnum.ILLEGAL_TOKEN.getCode())
                        || exception.getErrorCode().equals(DingTalkCodeEnum.TOKEN_TIME_OUT.getCode())) {
                    this.dingTalkRepository.expireAccessToken();
                    if (this.dingTalkRepository.autoRefreshToken()) {
                        continue;
                    }
                }

                if(exception.getErrorCode().equals(DingTalkCodeEnum.BUSY.getCode())) {
                    int sleepMillis = httpConfig.getRetrySleepMillis() * (1 << retryCount);
                    try {
                        log.warn("系统繁忙，{} ms 后重试(第{}次)", sleepMillis, retryCount);
                        Thread.sleep(sleepMillis);
                    } catch (InterruptedException e1) {
                        throw new RuntimeException(e1);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (++retryCount <= httpConfig.getMaxRetryCount());
        log.warn("达到最大重试次数:{}", this.httpConfig.getMaxRetryCount());
        throw new DingTalkException();
    }


}
