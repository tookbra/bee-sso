package com.tookbra.bee.dingtalk.api;

import com.tookbra.bee.dingtalk.api.addressBook.RoleService;
import com.tookbra.bee.dingtalk.api.addressBook.impl.RoleServiceImpl;
import com.tookbra.bee.dingtalk.bean.output.role.RoleListOutput;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
public class RoleServiceTest extends DingTalkServiceTest {

    private RoleService roleService;

    @Before
    public void init() {
        super.init();
        roleService = new RoleServiceImpl(super.getDingTalkService());
    }

    @Test
    public void getRolesTest() {
        RoleListOutput roleListOutput = roleService.getRoles();
        System.out.println(roleListOutput);
    }
}
