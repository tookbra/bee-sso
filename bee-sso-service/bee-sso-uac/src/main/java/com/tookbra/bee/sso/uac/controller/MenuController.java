package com.tookbra.bee.sso.uac.controller;


import com.tookbra.bee.model.result.BaseResult;
import com.tookbra.bee.model.validation.groups.SaveGroup;
import com.tookbra.bee.sso.uac.params.input.MenuInput;
import com.tookbra.bee.sso.uac.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author tookbra
 * @since 2019-03-05
 */
@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * 菜单树
     * @return
     */
    @GetMapping
    public BaseResult getMenuTree() {
        return BaseResult.success(menuService.getTree());
    }


    /**
     * 保存菜单
     * @param input
     * @return
     */
    @PostMapping
    public BaseResult saveMenu(@Validated(SaveGroup.class) MenuInput input) {
        menuService.saveMenu(input);
        return BaseResult.success("");
    }

    /**
     * 更新菜单
     * @param menuId 菜单id
     * @param input
     * @return
     */
    @PutMapping("/{menuId}")
    public BaseResult updateMenu(@PathVariable Integer menuId, MenuInput input) {
        input.setMenuId(menuId);
        menuService.updateMenu(input);
        return BaseResult.success("");
    }

    /**
     * 移除菜单
     * @param menuId 菜单id
     * @return
     */
    @DeleteMapping("/{menuId}")
    public BaseResult removeMenu(@PathVariable Integer menuId) {
        menuService.removeMenu(menuId);
        return BaseResult.success("");
    }
}

