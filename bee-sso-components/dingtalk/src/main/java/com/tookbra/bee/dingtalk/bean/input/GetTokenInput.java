package com.tookbra.bee.dingtalk.bean.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.AbstractDingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.token.TokenOutput;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class GetTokenInput extends AbstractDingTalkInput<TokenOutput> {

    private static final long serialVersionUID = -3742360749293610743L;
    /**
     * 应用的唯一标识key
     */
    @JsonProperty("appkey")
    private String appKey;
    /**
     * 应用的密钥
     */
    @JsonProperty("appsecret")
    private String appSecret;


    @Override
    public Class<TokenOutput> getClasses() {
        return TokenOutput.class;
    }

    @Override
    public String getParam() {
        return null;
    }
}
