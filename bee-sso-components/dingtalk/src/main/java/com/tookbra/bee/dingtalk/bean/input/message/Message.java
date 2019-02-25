package com.tookbra.bee.dingtalk.bean.input.message;

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

    private String msgtype;

    private MessageText text;

    @Data
    @ToString
    public static class MessageText {
        private String content;
    }
}
