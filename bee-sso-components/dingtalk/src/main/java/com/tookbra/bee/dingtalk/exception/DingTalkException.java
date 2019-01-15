package com.tookbra.bee.dingtalk.exception;

import lombok.Data;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
@Data
public class DingTalkException extends RuntimeException {

    private static final long serialVersionUID = 1916273941071191845L;

    /**
     * 错误码
     */
    private Integer errorCode;
    /**
     * 错误信息
     */
    private String message;

    public DingTalkException() {
        super();
    }

    public DingTalkException(String message) {
        super(message);
    }

    public DingTalkException(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
