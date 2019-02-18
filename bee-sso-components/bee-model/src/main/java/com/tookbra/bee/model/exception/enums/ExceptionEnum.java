package com.tookbra.bee.model.exception.enums;

/**
 * @author tookbra
 * @date 2019/2/15
 * @description
 */
public enum ExceptionEnum {
    SERVICE_ERROR(500, "服务器异常");

    private int code;

    private String message;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
