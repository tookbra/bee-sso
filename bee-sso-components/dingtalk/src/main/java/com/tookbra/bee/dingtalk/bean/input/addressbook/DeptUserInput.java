package com.tookbra.bee.dingtalk.bean.input.addressbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.AbstractDingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.DeptUserInfoOutput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.DeptUsersOutput;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description 获取部门用户
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class DeptUserInput extends AbstractDingTalkInput<DeptUserInfoOutput> {

    private static final long serialVersionUID = 616908457059721114L;
    /**
     * 通讯录语言(默认zh_CN另外支持en_US)
     */
    private String lang;
    /**
     * 部门Id
     */
    @JsonProperty("department_id")
    private long departmentId;


    @Override
    public Class<DeptUserInfoOutput> getClasses() {
        return DeptUserInfoOutput.class;
    }

    @Override
    public String getParam() {
        return null;
    }
}
