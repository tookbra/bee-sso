package com.tookbra.bee.sso.uac.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tookbra.bee.sso.uac.dao.base.RoleMenuMapper;
import com.tookbra.bee.sso.uac.domain.RoleMenu;
import com.tookbra.bee.sso.uac.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  角色菜单服务实现类
 * </p>
 *
 * @author tookbra
 * @since 2019-03-05
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRoleMenuId(Integer roleId, String menuIds) {
        this.remove(Wrappers.<RoleMenu>query().lambda()
                .eq(RoleMenu::getRoleId, roleId));

        List<RoleMenu> roleMenus = Arrays
                .stream(menuIds.split(","))
                .map(menuId -> {
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setRoleId(roleId);
                    roleMenu.setMenuId(Integer.valueOf(menuId));
                    return roleMenu;
                }).collect(Collectors.toList());

        this.saveBatch(roleMenus);
    }
}
