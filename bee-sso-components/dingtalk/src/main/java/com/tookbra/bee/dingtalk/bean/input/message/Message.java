package com.tookbra.bee.dingtalk.bean.input.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author tookbra
 * @date 2019/2/25
 * @description
 */
@Data
@ToString
public class Message implements Serializable {

    private static final long serialVersionUID = 5635618397618528472L;
    /**
     * 消息类型
     */
    @JsonProperty("msgtype")
    private String msgType;
    /**
     * 文本消息
     */
    private Text text;

    /**
     *
     */
    @Data
    @ToString
    public static class Text implements Serializable {
        private static final long serialVersionUID = -8567686475282541203L;
        private String content;
    }
}
