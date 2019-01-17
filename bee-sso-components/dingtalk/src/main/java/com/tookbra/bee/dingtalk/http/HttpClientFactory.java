package com.tookbra.bee.dingtalk.http;

import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.enums.DingTalkCodeEnum;
import com.tookbra.bee.dingtalk.exception.DingTalkException;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
import com.tookbra.bee.sso.core.utils.JackSonUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

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
        try {
            DingTalkOutput baseResult = JackSonUtil.objectMapper.readValue(result, DingTalkOutput.class);
            if (baseResult.getErrorCode() != DingTalkCodeEnum.SUCCESS.getCode()) {
                throw new DingTalkException(baseResult.getErrorCode(), baseResult.getErrorMsg());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new DingTalkException(-9999, "json parse error");
        }
        return result;
    }

}
