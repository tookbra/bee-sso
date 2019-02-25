package com.tookbra.bee.dingtalk.bean.output.message;

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
public class NormalMessageOutput extends DingTalkOutput {
    private static final long serialVersionUID = 5879000990365325222L;

    /**
     * 有有效接收者的userId
     */
    private String receiver;
}
