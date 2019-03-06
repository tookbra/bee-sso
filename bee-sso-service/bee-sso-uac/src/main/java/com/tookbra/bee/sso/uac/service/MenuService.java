package com.tookbra.bee.sso.uac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tookbra.bee.sso.uac.domain.Menu;
import com.tookbra.bee.sso.uac.params.input.MenuInput;
import com.tookbra.bee.sso.uac.params.output.MenuOutput;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author tookbra
 * @since 2019-03-05
 */
public interface MenuService extends IService<Menu> {

    /**
     * 获取部门树
     * @return
     */
    List<MenuOutput> getTree();

    /**
     * 添加菜单
     * @param input
     */
    void saveMenu(MenuInput input);

    /**
     * 更新菜单
     * @param input
     */
    void updateMenu(MenuInput input);

    /**
     * 移除菜单
     * @param menuId
     */
    void removeMenu(Integer menuId);
}
