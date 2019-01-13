package com.tookbra.bee.dingtalk.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tookbra.bee.dingtalk.bean.result.BaseResult;
import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.enums.DingTalkCodeEnum;
import com.tookbra.bee.dingtalk.exception.DingTalkException;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
@Data
@Slf4j
public abstract class HttpClientFactory {

    protected DingTalkProperties.HttpConfig httpConfig;

    protected ObjectMapper objectMapper = new ObjectMapper();

    protected DingTalkRepository dingTalkRepository;


    /**
     *
     * @param result
     * @return
     */
    protected String filterResult(String result) throws DingTalkException {
        BaseResult baseResult = this.objectMapper.convertValue(result, BaseResult.class);
        if(baseResult.getErrorCode() != DingTalkCodeEnum.SUCCESS.getCode()) {
            throw new DingTalkException(baseResult.getErrorCode(), baseResult.getErrorMsg());
        }
        return result;
    }

}
