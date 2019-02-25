package com.tookbra.bee.dingtalk.bean.input.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.AbstractDingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.message.JobMessageResultOutput;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/2/25
 * @description
 */
@Data
@ToString
public class JobMessageResultInput extends AbstractDingTalkInput<JobMessageResultOutput> {

    private static final long serialVersionUID = -5334826336012927839L;
    /**
     * 发送消息时使用的微应用的id
     */
    @JsonProperty("agent_id")
    private String agentId;
    /**
     * 发送消息时钉钉返回的任务id
     */
    @JsonProperty("task_id")
    private Integer taskId;

    @Override
    public Class<JobMessageResultOutput> getClasses() {
        return JobMessageResultOutput.class;
    }

    @Override
    public String getParam() {
        return null;
    }
}
