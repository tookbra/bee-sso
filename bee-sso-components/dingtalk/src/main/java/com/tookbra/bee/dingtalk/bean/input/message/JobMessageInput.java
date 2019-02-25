package com.tookbra.bee.dingtalk.bean.input.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.AbstractDingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.message.JobMessageOutput;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/2/25
 * @description
 */
@Data
@ToString
public class JobMessageInput extends AbstractDingTalkInput<JobMessageOutput> {

    private static final long serialVersionUID = -4355969079311179261L;
    /**
     * 应用agentId
     */
    @JsonProperty("agent_id")
    private Integer agentId;
    /**
     * 接收者的用户userid列表，最大列表长度：20
     */
    @JsonProperty("userid_list")
    private String userIds;
    /**
     * 接收者的用户userid列表，最大列表长度：20
     */
    @JsonProperty("dept_id_list")
    private String deptIds;
    /**
     * 是否发送给企业全部用户
     */
    @JsonProperty("to_all_user")
    private boolean toAllUser = false;
    /**
     * 消息内容，具体见“消息类型与数据格式”。最长不超过2048个字节
     */
    private Message msg;

    @Override
    public Class<JobMessageOutput> getClasses() {
        return JobMessageOutput.class;
    }

    @Override
    public String getParam() {
        return null;
    }
}
