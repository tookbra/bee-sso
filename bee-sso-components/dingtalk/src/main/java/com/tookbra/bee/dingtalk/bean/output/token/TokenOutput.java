package com.tookbra.bee.dingtalk.bean.output.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
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
public class TokenOutput extends DingTalkOutput {

    private static final long serialVersionUID = 5611745617082856334L;
    /**
     * 凭证
     */
    @JsonProperty("access_token")
    private String accessToken;
    /**
     * 过期时间
     */
    @JsonProperty("expires_in")
    private Integer expiresIn;
}
