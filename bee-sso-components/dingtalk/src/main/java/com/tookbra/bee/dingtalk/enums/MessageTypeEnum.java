package com.tookbra.bee.dingtalk.enums;

/**
 * @author tookbra
 * @date 2019/2/26
 * @description
 */
public enum MessageTypeEnum {
    TEXT("text");

    private String type;
    MessageTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
