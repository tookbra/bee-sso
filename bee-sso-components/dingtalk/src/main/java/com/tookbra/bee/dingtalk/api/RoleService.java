package com.tookbra.bee.dingtalk.api;

import com.tookbra.bee.dingtalk.bean.output.role.RoleListOutput;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
public interface RoleService {

    String ROLE_LIST_URL = "https://oapi.dingtalk.com/topapi/role/list";

    /**
     * 获取角色列表
     * https://oapi.dingtalk.com/topapi/role/list?access_token=ACCESS_TOKEN
     * @return
     */
    RoleListOutput getRoles();
}
