package com.tookbra.bee.model.exception;

import lombok.Data;

/**
 * 业务异常
 * @author tookbra
 * @date 2019/2/15
 * @description
 */
@Data
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 7044736681419292797L;
    /**
     * 错误代码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String message;

    public BizException(String message) {
        super(message);
    }

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
