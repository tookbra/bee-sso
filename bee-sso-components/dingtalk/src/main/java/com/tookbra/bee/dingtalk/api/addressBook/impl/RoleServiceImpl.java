package com.tookbra.bee.dingtalk.api.addressBook.impl;

import com.tookbra.bee.dingtalk.api.addressBook.DingTalkService;
import com.tookbra.bee.dingtalk.api.addressBook.RoleService;
import com.tookbra.bee.dingtalk.bean.input.role.RoleListInput;
import com.tookbra.bee.dingtalk.bean.output.role.RoleListOutput;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
public class RoleServiceImpl implements RoleService {

    private DingTalkService dingTalkService;

    public RoleServiceImpl(DingTalkService dingTalkService) {
        this.dingTalkService = dingTalkService;
    }

    @Override
    public RoleListOutput getRoles() {
        RoleListInput roleListInput = new RoleListInput();
        return this.dingTalkService.get(RoleService.ROLE_LIST_URL, roleListInput);
    }
}
