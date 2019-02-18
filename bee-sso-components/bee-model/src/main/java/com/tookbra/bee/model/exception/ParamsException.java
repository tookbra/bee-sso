package com.tookbra.bee.model.exception;

/**
 * @author tookbra
 * @date 2019/2/18
 * @description
 */
public class ParamsException extends RuntimeException {

    /**
     * 错误代码
     */
    private int code = 500;
    /**
     * 错误信息
     */
    private String message;

    public ParamsException(String message) {
        super(message);
        this.message = message;
    }

    public ParamsException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
