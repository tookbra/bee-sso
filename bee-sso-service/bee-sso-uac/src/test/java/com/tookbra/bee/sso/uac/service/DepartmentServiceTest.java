package com.tookbra.bee.sso.uac.service;

import com.tookbra.bee.sso.uac.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tookbra
 * @date 2019/3/4
 * @description
 */
public class DepartmentServiceTest extends AbstractTest {

    @Autowired
    DepartmentService departmentService;

    @Test
    public void getTreeTest() {
        departmentService.getTree();
    }

    @Test
    public void getDeptByIdTest() {
        departmentService.getDeptById(1);
    }
}
