package com.tookbra.bee.sso.uac.service;

import com.tookbra.bee.model.page.PageInfo;
import com.tookbra.bee.sso.uac.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tookbra
 * @date 2019/3/4
 * @description
 */
public class RoleServiceTest extends AbstractTest {

    @Autowired
    RoleService roleService;

    @Test
    public void pageRoleTest() {
        roleService.pageRole(new PageInfo());
    }
}
