package com.tookbra.bee.dingtalk.bean.output.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/2/25
 * @description
 */
@Data
@ToString
public class JobMessageOutput extends DingTalkOutput {
    private static final long serialVersionUID = 2876499494640012278L;

    /**
     * 创建的发送任务id
     */
    @JsonProperty("task_id")
    private Integer taskId;
}
