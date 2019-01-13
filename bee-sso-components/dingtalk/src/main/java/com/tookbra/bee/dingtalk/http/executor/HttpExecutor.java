package com.tookbra.bee.dingtalk.http.executor;

import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.enums.DingTalkCodeEnum;
import com.tookbra.bee.dingtalk.exception.DingTalkException;
import com.tookbra.bee.dingtalk.http.HttpClient;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
@Slf4j
public class HttpExecutor {

    private HttpClient httpClient;
    private DingTalkProperties.HttpConfig httpConfig;
    private DingTalkRepository dingTalkRepository;

    public HttpExecutor(HttpClient httpClient, DingTalkProperties.HttpConfig httpConfig, DingTalkRepository dingTalkRepository) {
        this.httpClient = httpClient;
        this.httpConfig = httpConfig;
        this.dingTalkRepository = dingTalkRepository;
    }

    public void post(String url, String data) {
        int retryCount = 0;
        while(retryCount ++ <= httpConfig.getMaxRetryCount()) {
            try {
                httpClient.post(url, data);
            } catch (DingTalkException exception) {
                if (exception.getErrorCode().equals(DingTalkCodeEnum.TOKEN_ERROR.getCode())
                        || exception.getErrorCode().equals(DingTalkCodeEnum.ILLEGAL_TOKEN.getCode())
                        || exception.getErrorCode().equals(DingTalkCodeEnum.TOKEN_TIME_OUT.getCode())) {
                    this.dingTalkRepository.expireAccessToken();
                    if (this.dingTalkRepository.autoRefreshToken()) {

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
    }

    public void get(String url, String data) {

    }
}
