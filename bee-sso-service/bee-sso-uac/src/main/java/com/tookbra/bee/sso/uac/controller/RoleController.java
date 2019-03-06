package com.tookbra.bee.sso.uac.controller;


import com.tookbra.bee.model.page.PageInfo;
import com.tookbra.bee.model.page.PageResult;
import com.tookbra.bee.model.result.BaseResult;
import com.tookbra.bee.sso.uac.params.output.RoleOutput;
import com.tookbra.bee.sso.uac.service.RoleMenuService;
import com.tookbra.bee.sso.uac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色
 前端控制器
 * </p>
 *
 * @author tookbra
 * @since 2019-03-04
 */
@RestController
@RequestMapping("/role")
public class RoleController {


    @Autowired
    RoleService roleService;

    @Autowired
    RoleMenuService roleMenuService;

    /**
     * 分页查询角色
     * @param pageInfo 分页信息
     * @return
     */
    @GetMapping
    public PageResult<RoleOutput> pageRole(PageInfo pageInfo) {
        return PageResult.success(roleService.pageRole(pageInfo));
    }

    /**
     * 更新角色菜单
     * @param roleId
     * @param menuIds
     * @return
     */
    @PostMapping("/{roleId}/menu")
    public BaseResult saveRoleMenu(@PathVariable Integer roleId, @RequestParam("menuIds") String menuIds) {
        roleMenuService.saveRoleMenuId(roleId, menuIds);
        return BaseResult.success("");
    }
}

