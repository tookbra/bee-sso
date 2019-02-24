package com.tookbra.bee.dingtalk.api;

import com.tookbra.bee.dingtalk.api.addressBook.DeptService;
import com.tookbra.bee.dingtalk.api.addressBook.impl.DeptServiceImpl;
import com.tookbra.bee.dingtalk.bean.input.department.DepartmentListInput;
import com.tookbra.bee.dingtalk.bean.output.department.DepartmentInfoOutput;
import com.tookbra.bee.dingtalk.bean.output.department.DepartmentListOutput;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
public class DeptServiceTest extends DingTalkServiceTest {

    private DeptService deptService;

    @Before
    public void init() {
        super.init();
        deptService = new DeptServiceImpl(super.getDingTalkService());
    }

    @Test
    public void getDeptInfoTest() {
        DepartmentInfoOutput departmentInfoOutput = deptService.getDeptInfo(1L);
        System.out.println(departmentInfoOutput);

    }

    @Test
    public void getDeptListTest() {
        DepartmentListInput departmentListInput = new DepartmentListInput();
        DepartmentListOutput departmentListOutput = deptService.getDeptList(departmentListInput);
        System.out.println(departmentListOutput);
    }
}
