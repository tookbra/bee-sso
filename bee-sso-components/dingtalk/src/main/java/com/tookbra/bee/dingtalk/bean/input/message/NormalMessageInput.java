package com.tookbra.bee.dingtalk.bean.input.message;

import com.tookbra.bee.dingtalk.bean.AbstractDingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.message.NormalMessageOutput;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/2/22
 * @description
 */
@Data
@ToString
public class NormalMessageInput extends AbstractDingTalkInput<NormalMessageOutput> {

    private static final long serialVersionUID = 4783397456874031917L;
    /**
     * 消息发送者 userId
     */
    private String sender;
    /**
     * 群消息或者个人聊天会话Id，(通过JSAPI的dd.chooseChatForNormalMsg接口唤起联系人界面选择之后即可拿到会话ID，之后您可以使用获取到的cid调用此接口）
     */
    private String cid;
    /**
     * 消息内容，具体见“消息类型与数据格式”。最长不超过2048个字节
     */
    private String msg;

    @Override
    public Class<NormalMessageOutput> getClasses() {
        return NormalMessageOutput.class;
    }

    @Override
    public String getParam() {
        return null;
    }
}
