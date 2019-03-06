package com.tookbra.bee.sso.uac.service;

import com.tookbra.bee.sso.uac.AbstractTest;
import com.tookbra.bee.sso.uac.params.input.MenuInput;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tookbra
 * @date 2019/3/5
 * @description
 */
public class MenuServiceTest extends AbstractTest {

    @Autowired
    MenuService menuService;

    @Test
    public void getTreeTest() {
        menuService.getTree();
    }

    @Test
    public void saveMenu() {
        MenuInput input = new MenuInput();
        input.setParentId(-1);
        input.setName("test");
        input.setMenuType(0);
        menuService.saveMenu(input);
    }

    @Test
    public void updateMenu() {
        MenuInput input = new MenuInput();
        input.setMenuId(1);
        menuService.updateMenu(input);
    }

    @Test
    public void removeMenu() {
        menuService.removeMenu(2);
    }
}
