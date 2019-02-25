package com.tookbra.bee.dingtalk.api.message;

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
 * @date 2019/2/22
 * @description
 */
public interface MessageService {

    /**
     * 发送普通消息地址
     */
    String NORMAL_URL = "https://oapi.dingtalk.com/message/send_to_conversation";
    /**
     * 发送工作通知地址
     */
    String JOB_URL = "https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2";
    /**
     * 工作通知消息的发送进度地址
     */
    String JOB_PROGRESS_URL = "https://oapi.dingtalk.com/topapi/message/corpconversation/getsendprogress";
    /**
     * 工作通知消息的发送结果地址
     */
    String JOB_RESULT_URL = "https://oapi.dingtalk.com/topapi/message/corpconversation/getsendresult";

    /**
     * 发送普通消息
     * https://oapi.dingtalk.com/message/send_to_conversation?access_token=ACCESS_TOKEN
     * @param input
     */
    NormalMessageOutput sendNormalMessage(NormalMessageInput input);

    /**
     * 发送工作通知
     * https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2?access_token=ACCESS_TOKEN
     * @param input
     */
    JobMessageOutput sendJobMessage(JobMessageInput input);

    /**
     * 查询工作通知消息的发送进度
     * https://oapi.dingtalk.com/topapi/message/corpconversation/getsendprogress?access_token=ACCESS_TOKEN
     * @param input
     * @return
     */
    JobMessageProgressOutput getJobSendProgress(JobMessageProgressInput input);

    /**
     * 查询工作通知消息的发送结果
     * https://oapi.dingtalk.com/topapi/message/corpconversation/getsendresult?access_token=ACCESS_TOKEN
     */
    JobMessageResultOutput getJobSendResult(JobMessageResultInput input);
}
