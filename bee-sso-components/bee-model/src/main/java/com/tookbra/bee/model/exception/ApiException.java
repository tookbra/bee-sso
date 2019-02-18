package com.tookbra.bee.model.exception;

import lombok.Data;

/**
 * 接口异常
 * @author tookbra
 * @date 2019/2/15
 * @description
 */
@Data
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1363810160766423389L;
    /**
     * 错误代码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String message;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
