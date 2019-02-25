package com.tookbra.bee.dingtalk.bean.input.department;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.AbstractDingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.department.DepartmentListOutput;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
@Data
@ToString
public class DepartmentListInput extends AbstractDingTalkInput<DepartmentListOutput> {

    private static final long serialVersionUID = -9092939202340529385L;
    /**
     * 是否递归部门的全部子部门，ISV微应用固定传递false
     */
    @JsonProperty("fetch_child")
    private boolean fetchChild = true;
    /**
     * 父部门id（如果不传，默认部门为根部门，根部门ID为1）
     */
    private Long id = 1L;

    @Override
    public Class<DepartmentListOutput> getClasses() {
        return DepartmentListOutput.class;
    }

    @Override
    public String getParam() {
        return null;
    }
}
