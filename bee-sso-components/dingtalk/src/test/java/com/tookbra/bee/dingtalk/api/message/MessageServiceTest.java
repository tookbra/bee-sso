package com.tookbra.bee.dingtalk.api.message;

import com.tookbra.bee.dingtalk.api.DingTalkServiceTest;
import com.tookbra.bee.dingtalk.api.message.impl.MessageServiceImpl;
import com.tookbra.bee.dingtalk.bean.input.message.JobMessageInput;
import com.tookbra.bee.dingtalk.bean.input.message.Message;
import com.tookbra.bee.dingtalk.bean.output.message.JobMessageOutput;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tookbra
 * @date 2019/2/25
 * @description
 */
public class MessageServiceTest extends DingTalkServiceTest {

    private MessageService messageService;

    @Before
    public void init() {
        super.init();
        messageService = new MessageServiceImpl(super.getDingTalkService());
    }

    @Test
    public void sendJobMessageTest() {
        JobMessageInput jobMessageInput = new JobMessageInput();
        jobMessageInput.setAgentId(191831230);
        jobMessageInput.setUserIds("01023131539572");
        Message.MessageText messageText = new Message.MessageText();
        messageText.setContent("cccc");
        Message message = new Message();
        message.setMsgtype("text");
        message.setText(messageText);
        jobMessageInput.setMsg(message);
        JobMessageOutput jobMessageOutput = messageService.sendJobMessage(jobMessageInput);
        System.out.println(jobMessageOutput);
    }
}
