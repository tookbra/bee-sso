package com.tookbra.bee.dingtalk.http.executor;

import com.tookbra.bee.dingtalk.bean.DingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.enums.DingTalkCodeEnum;
import com.tookbra.bee.dingtalk.enums.HttpMethodEnum;
import com.tookbra.bee.dingtalk.exception.DingTalkException;
import com.tookbra.bee.dingtalk.http.HttpClient;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
import com.tookbra.bee.sso.core.utils.JackSonUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
@Slf4j
public class DefaultHttpExecutor implements HttpExecutor {

    private HttpClient httpClient;
    private DingTalkProperties.HttpConfig httpConfig;
    private DingTalkRepository dingTalkRepository;
    private String url;

    public DefaultHttpExecutor(HttpClient httpClient, DingTalkProperties.HttpConfig httpConfig, DingTalkRepository dingTalkRepository) {
        this.httpClient = httpClient;
        this.httpConfig = httpConfig;
        this.dingTalkRepository = dingTalkRepository;
    }

    public DefaultHttpExecutor setUrl(String url) {
        this.url = url;
        return this;
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
        while(++retryCount <= httpConfig.getMaxRetryCount()) {
            try {
                String accessToken = "";
                StringBuilder sb = new StringBuilder(url);
                url = sb.append((url.contains("?") ? "&" : "?") + "access_token=" + accessToken).toString();
                String result = "";
                switch (httpMethodEnum) {
                    case GET:
                        result = httpClient.get(url, input.getParam());
                        break;
                    case POST:
                        result = httpClient.post(url, input.getParam());
                        break;
                    default:
                }
                log.debug("请求地址:{}, 请求参数:{}, 请求结果:{}", url, input.getParam(), result);
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
        }
        log.warn("达到最大重试次数:{}", this.httpConfig.getMaxRetryCount());
        throw new DingTalkException();
    }
}
