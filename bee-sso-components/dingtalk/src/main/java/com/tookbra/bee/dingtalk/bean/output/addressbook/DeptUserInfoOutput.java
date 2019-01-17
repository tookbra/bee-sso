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
 * @description 部门用户详情
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class DeptUserInfoOutput extends DingTalkOutput {
    private static final long serialVersionUID = -3737145400627400612L;

    /**
     * 用户列表
     */
    @JsonProperty("userlist")
    private List<UserInfoOutput> userList;
}
