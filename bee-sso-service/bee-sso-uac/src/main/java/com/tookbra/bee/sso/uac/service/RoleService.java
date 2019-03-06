package com.tookbra.bee.sso.uac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tookbra.bee.model.page.PageInfo;
import com.tookbra.bee.sso.uac.domain.Role;
import com.tookbra.bee.sso.uac.params.output.RoleOutput;

/**
 * <p>
 * 角色
 服务类
 * </p>
 *
 * @author tookbra
 * @since 2019-03-04
 */
public interface RoleService extends IService<Role> {

    /**
     * 分页查询角色
     * @param pageInfo
     * @return
     */
    IPage<RoleOutput> pageRole(PageInfo pageInfo);
}
