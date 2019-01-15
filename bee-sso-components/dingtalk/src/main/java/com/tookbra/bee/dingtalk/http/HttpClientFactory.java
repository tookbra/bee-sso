package com.tookbra.bee.dingtalk.http;

import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.enums.DingTalkCodeEnum;
import com.tookbra.bee.dingtalk.exception.DingTalkException;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
import com.tookbra.bee.sso.core.utils.JackSonUtil;
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

    protected DingTalkRepository dingTalkRepository;


    /**
     *
     * @param result
     * @return
     */
    protected String filterResult(String result) throws DingTalkException {
        DingTalkOutput baseResult = JackSonUtil.objectMapper.convertValue(result, DingTalkOutput.class);
        if(baseResult.getErrorCode() != DingTalkCodeEnum.SUCCESS.getCode()) {
            throw new DingTalkException(baseResult.getErrorCode(), baseResult.getErrorMsg());
        }
        return result;
    }

}
