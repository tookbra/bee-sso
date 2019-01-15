package com.tookbra.bee.dingtalk.bean.output.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
@Data
@ToString
public class TokenOutput extends DingTalkOutput {

    /**
     *
     */
    @JsonProperty("access_token")
    private String accessToken;
    /**
     * 过期时间
     */
    private long expiresIn;
}
