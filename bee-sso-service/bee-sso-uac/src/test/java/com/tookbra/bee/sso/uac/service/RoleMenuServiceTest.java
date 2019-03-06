package com.tookbra.bee.sso.uac.service;

import com.tookbra.bee.sso.uac.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tookbra
 * @date 2019/3/5
 * @description
 */
public class RoleMenuServiceTest extends AbstractTest {

    @Autowired
    RoleMenuService roleMenuService;

    @Test
    public void saveRoleMenuIdTest() {
        roleMenuService.saveRoleMenuId(1, "1,2");
    }
}
