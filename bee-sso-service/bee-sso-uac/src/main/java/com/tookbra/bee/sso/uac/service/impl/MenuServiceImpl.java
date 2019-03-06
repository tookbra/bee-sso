package com.tookbra.bee.sso.uac.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tookbra.bee.sso.core.utils.TransferUtil;
import com.tookbra.bee.sso.uac.dao.base.MenuMapper;
import com.tookbra.bee.sso.uac.domain.Menu;
import com.tookbra.bee.sso.uac.params.input.MenuInput;
import com.tookbra.bee.sso.uac.params.output.MenuOutput;
import com.tookbra.bee.sso.uac.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author tookbra
 * @since 2019-03-05
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public List<MenuOutput> getTree() {
        return buildMenuTree(this.list(Wrappers.emptyWrapper()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveMenu(MenuInput input) {
        Menu menu = new Menu();
        TransferUtil.transfer(input, menu);
        this.save(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMenu(MenuInput input) {
        Menu menu = new Menu();
        TransferUtil.transfer(input, menu);
        this.updateById(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeMenu(Integer menuId) {
        this.removeById(menuId);
    }


    public List<MenuOutput> buildMenuTree(List<Menu> menus) {
        List<MenuOutput> menuOutputs = new ArrayList<>();
        for (Menu menu : menus) {
            MenuOutput menuOutput = new MenuOutput();
            TransferUtil.transfer(menu, menuOutput);
            if(menuOutput.getParentId() == -1) {
                menuOutputs.add(menuOutput);
            }
            for(Menu menuNode : menus) {
                if(menuNode.getParentId().equals(menuOutput.getMenuId())) {
                    List<MenuOutput> nodes = menuOutput.getChildren();
                    if(CollectionUtils.isEmpty(nodes)) {
                        nodes = new ArrayList<>();
                    }
                    MenuOutput node = new MenuOutput();
                    TransferUtil.transfer(menuNode, node);
                    nodes.add(node);
                    menuOutput.setChildren(nodes);
                }
            }
        }
        return menuOutputs;
    }
}
