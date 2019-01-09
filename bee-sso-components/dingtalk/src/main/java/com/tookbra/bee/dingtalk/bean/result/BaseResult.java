package com.tookbra.bee.dingtalk.bean.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 *
 * @author tookbra
 * @date 2019/1/9
 * @description
 */
@Data
@ToString
public abstract class BaseResult implements Serializable {

    /**
     * 返回码
     */
    @JsonProperty("errcode")
    private int errorCode;
    /**
     * 对返回码的文本描述内容
     */
    @JsonProperty("errmsg")
    private String errorMsg;
}
