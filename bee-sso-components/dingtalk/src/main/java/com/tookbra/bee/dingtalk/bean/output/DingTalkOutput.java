package com.tookbra.bee.dingtalk.bean.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class DingTalkOutput implements Serializable {

    private static final long serialVersionUID = -6247817857607343618L;
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
    /**
     * 在分页查询时返回，代表是否还有下一页更多数据
     */
    private boolean hasMore;
}
