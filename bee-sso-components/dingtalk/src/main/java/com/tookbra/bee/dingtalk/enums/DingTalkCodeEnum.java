package com.tookbra.bee.dingtalk.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * 接口错误码
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
public enum DingTalkCodeEnum {

    SUCCESS(0),
    BUSY(-1),
    TOKEN_ERROR(40001),
    ILLEGAL_TOKEN(40014),
    TOKEN_TIME_OUT(42001);

    private Integer code;

    DingTalkCodeEnum(final Integer code) {
        this.code = code;
    }

    public static DingTalkCodeEnum getCode(final Integer code) {
        Optional<DingTalkCodeEnum> dingTalkCodeEnum =
                Arrays.stream(DingTalkCodeEnum.values())
                        .filter(d -> Objects.equals(d.getCode(), code))
                        .findFirst();
        return dingTalkCodeEnum.get();
    }

    public Integer getCode() {
        return code;
    }
}
