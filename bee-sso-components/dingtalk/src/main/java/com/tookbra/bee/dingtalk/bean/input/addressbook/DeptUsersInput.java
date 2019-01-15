package com.tookbra.bee.dingtalk.bean.input.addressbook;

import com.tookbra.bee.dingtalk.bean.AbstractDingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.DeptUsersOutput;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description 获取部门用户userId列表
 */
@Data
@ToString
public class DeptUsersInput extends AbstractDingTalkInput<DeptUsersOutput> {

    /**
     * 部门id
     */
    private String deptId;

    @Override
    public Class<DeptUsersOutput> getClasses() {
        return DeptUsersOutput.class;
    }

    @Override
    public String getParam() {
        return null;
    }
}
