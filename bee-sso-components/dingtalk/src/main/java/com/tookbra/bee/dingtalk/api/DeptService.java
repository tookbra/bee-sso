package com.tookbra.bee.dingtalk.api;

import com.tookbra.bee.dingtalk.bean.input.department.DepartmentListInput;
import com.tookbra.bee.dingtalk.bean.output.department.DepartmentInfoOutput;
import com.tookbra.bee.dingtalk.bean.output.department.DepartmentListOutput;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
public interface DeptService {

    String DEPARTMENT_URL = "https://oapi.dingtalk.com/department/list";

    String DEPARTMENT_INFO_URL = "https://oapi.dingtalk.com/department/get";


    /**
     * 获取部门详情
     * https://oapi.dingtalk.com/department/get?access_token=ACCESS_TOKEN&id=123
     * @param departId
     * @return
     */
    DepartmentInfoOutput getDeptInfo(Long departId);

    /**
     * 获取部门列表
     * https://oapi.dingtalk.com/department/list?access_token=ACCESS_TOKEN
     * @param departmentListInput
     * @return
     */
    DepartmentListOutput getDeptList(DepartmentListInput departmentListInput);
}
