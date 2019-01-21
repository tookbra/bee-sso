package com.tookbra.bee.dingtalk.bean.input.department;

import com.tookbra.bee.dingtalk.bean.AbstractDingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.department.DepartmentInfoOutput;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
@Data
@ToString
public class DepartmentInfoInput extends AbstractDingTalkInput<DepartmentInfoOutput> {

    private static final long serialVersionUID = 9011577530596210992L;
    /**
     * 部门id
     */
    private Long id;

    @Override
    public Class<DepartmentInfoOutput> getClasses() {
        return DepartmentInfoOutput.class;
    }

    @Override
    public String getParam() {
        return null;
    }
}
