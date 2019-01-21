package com.tookbra.bee.dingtalk.bean.input.role;

import com.tookbra.bee.dingtalk.bean.AbstractDingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.role.RoleListOutput;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
@Data
@ToString
public class RoleListInput extends AbstractDingTalkInput<RoleListOutput> {
    private static final long serialVersionUID = 3390447572766183279L;

    @Override
    public Class<RoleListOutput> getClasses() {
        return RoleListOutput.class;
    }

    @Override
    public String getParam() {
        return null;
    }
}
