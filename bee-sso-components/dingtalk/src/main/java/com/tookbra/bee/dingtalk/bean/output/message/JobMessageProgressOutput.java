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
public class JobMessageProgressOutput extends DingTalkOutput {
    private static final long serialVersionUID = -1776234801793594899L;

    private JobMessageProgress progress;

    @Data
    @ToString
    public class JobMessageProgress implements Serializable {
        private static final long serialVersionUID = 564690067067726094L;
        /**
         * 取值 0-100，表示处理的百分比
         */
        @JsonProperty("progress_in_percent")
        private Integer progressInPercent;
        /**
         * 任务执行状态，0=未开始，1=处理中，2=处理完毕
         */
        private Integer status;
    }
}
