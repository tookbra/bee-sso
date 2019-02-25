package com.tookbra.bee.dingtalk.bean.output.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author tookbra
 * @date 2019/2/25
 * @description
 */
@Data
@ToString
public class JobMessageResultOutput extends DingTalkOutput {

    private static final long serialVersionUID = -8352925479981316994L;

    @JsonProperty("send_result")
    private JobMessageResult result;


    public class JobMessageResult implements Serializable {

        private static final long serialVersionUID = 3433929915883746901L;
        /**
         * 无效的用户id
         */
        @JsonProperty("invalid_user_id_list")
        private String invalidUserIds;
        /**
         * 因发送消息超过上限而被流控过滤后实际未发送的userid。未被限流的接收者仍会被收到消息。
         * 限流规则包括：
         * 1、同一个微应用相同消息的内容同一个用户一天只能接收一次。
         * 2、同一个微应用给同一个用户发送消息，如果是ISV应用开发方式一天不得超过50次；如果是企业内部开发方式，此上限为500次。
         */
        @JsonProperty("forbidden_user_id_list")
        private String forbiddenUserIds;
        /**
         * 发送失败的用户id
         */
        @JsonProperty("failed_user_id_list")
        private String failedUserIds;
        /**
         * 已读消息的用户id
         */
        @JsonProperty("read_user_id_list")
        private String readUserIds;
        /**
         * 未读消息的用户id
         */
        @JsonProperty("unread_user_id_list")
        private String unreadUserIds;
        /**
         * 无效的部门id
         */
        @JsonProperty("invalid_dept_id_list")
        private String invalidDeptIds;
    }
}
