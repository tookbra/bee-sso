package com.tookbra.bee.sso.uac.controller;

import com.tookbra.bee.model.page.PageResult;
import com.tookbra.bee.model.result.BaseResult;
import com.tookbra.bee.sso.uac.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tookbra
 * @date 2019/3/4
 * @description
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    /**
     * 部门树
     * @return
     */
    @GetMapping
    public BaseResult deptTree() {
        return PageResult.success(departmentService.getTree());
    }

    /**
     * 获取部门详情
     * @param deptId 部门id
     * @return
     */
    @GetMapping("/{deptId}")
    public BaseResult getDepartment(@PathVariable Integer deptId) {
        return BaseResult.success(departmentService.getDeptById(deptId));
    }
}
