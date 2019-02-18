package com.tookbra.bee.model.result;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author tookbra
 * @date 2019/2/15
 * @description
 */
@Data
@ToString
public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = -6202473061170486553L;

    /**
     * 是否成功
     */
    private boolean success = true;
    /**
     * 代码
     */
    private int code = 200;
    /**
     * 消息
     */
    private String message;
    /**
     * 返回数据
     */
    private T Data;

    public static BaseResult error(int code, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(code);
        baseResult.setMessage(message);
        return baseResult;
    }

    public static <T> BaseResult success(T data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setData(data);
        return baseResult;
    }
}
