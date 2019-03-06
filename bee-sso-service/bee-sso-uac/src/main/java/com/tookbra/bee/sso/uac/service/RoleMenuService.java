package com.tookbra.bee.sso.uac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tookbra.bee.sso.uac.domain.RoleMenu;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tookbra
 * @since 2019-03-05
 */
public interface RoleMenuService extends IService<RoleMenu> {

    /**
     * 更新角色菜单
     * @param roleId 角色id
     * @param menuIds 菜单id
     */
    void saveRoleMenuId(Integer roleId, String menuIds);
}
