package com.tookbra.bee.dingtalk.api.impl;

import com.tookbra.bee.dingtalk.api.DeptService;
import com.tookbra.bee.dingtalk.api.DingTalkService;
import com.tookbra.bee.dingtalk.bean.input.department.DepartmentInfoInput;
import com.tookbra.bee.dingtalk.bean.input.department.DepartmentListInput;
import com.tookbra.bee.dingtalk.bean.output.department.DepartmentInfoOutput;
import com.tookbra.bee.dingtalk.bean.output.department.DepartmentListOutput;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
public class DeptServiceImpl implements DeptService {

    private DingTalkService dingTalkService;

    public DeptServiceImpl(DingTalkService dingTalkService) {
        this.dingTalkService = dingTalkService;
    }

    @Override
    public DepartmentInfoOutput getDeptInfo(Long departId) {
        DepartmentInfoInput departmentInfoInput = new DepartmentInfoInput();
        departmentInfoInput.setId(departId);
        return dingTalkService.get(DeptService.DEPARTMENT_INFO_URL, departmentInfoInput);
    }

    @Override
    public DepartmentListOutput getDeptList(DepartmentListInput departmentListInput) {
        return dingTalkService.get(DeptService.DEPARTMENT_URL, departmentListInput);
    }
}
