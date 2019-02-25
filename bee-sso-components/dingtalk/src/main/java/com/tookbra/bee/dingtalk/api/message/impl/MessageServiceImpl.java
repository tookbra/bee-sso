package com.tookbra.bee.dingtalk.api.message.impl;

import com.tookbra.bee.dingtalk.api.DingTalkService;
import com.tookbra.bee.dingtalk.api.message.MessageService;
import com.tookbra.bee.dingtalk.bean.input.message.JobMessageInput;
import com.tookbra.bee.dingtalk.bean.input.message.JobMessageProgressInput;
import com.tookbra.bee.dingtalk.bean.input.message.JobMessageResultInput;
import com.tookbra.bee.dingtalk.bean.input.message.NormalMessageInput;
import com.tookbra.bee.dingtalk.bean.output.message.JobMessageOutput;
import com.tookbra.bee.dingtalk.bean.output.message.JobMessageProgressOutput;
import com.tookbra.bee.dingtalk.bean.output.message.JobMessageResultOutput;
import com.tookbra.bee.dingtalk.bean.output.message.NormalMessageOutput;

/**
 * @author tookbra
 * @date 2019/2/25
 * @description
 */
public class MessageServiceImpl implements MessageService {

    private DingTalkService dingTalkService;

    public MessageServiceImpl(DingTalkService dingTalkService) {
        this.dingTalkService = dingTalkService;
    }

    @Override
    public NormalMessageOutput sendNormalMessage(NormalMessageInput input) {
        return this.dingTalkService.post(NORMAL_URL, input);
    }

    @Override
    public JobMessageOutput sendJobMessage(JobMessageInput input) {
        return this.dingTalkService.post(JOB_URL, input);
    }

    @Override
    public JobMessageProgressOutput getJobSendProgress(JobMessageProgressInput input) {
        return this.dingTalkService.post(JOB_PROGRESS_URL, input);
    }

    @Override
    public JobMessageResultOutput getJobSendResult(JobMessageResultInput input) {
        return this.dingTalkService.post(JOB_RESULT_URL, input);
    }
}
