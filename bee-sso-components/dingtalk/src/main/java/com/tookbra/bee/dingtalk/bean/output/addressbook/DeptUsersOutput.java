package com.tookbra.bee.dingtalk.bean.output.addressbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description 获取部门用户userId列表
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class DeptUsersOutput extends DingTalkOutput {

    /**
     * userId列表
     */
    @JsonProperty("userIds")
    private List<Long> userIds;
}
