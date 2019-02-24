package com.tookbra.bee.dingtalk.api.message;

/**
 * @author tookbra
 * @date 2019/2/22
 * @description
 */
public interface MessageService {

    /**
     * 发送普通消息地址
     */
    String NORMAL_URL = "https://oapi.dingtalk.com/message/send_to_conversation";

    void sendNormalMessage()
}
