package com.tookbra.bee.sso.uac.controller;


import com.tookbra.bee.model.page.PageResult;
import com.tookbra.bee.model.result.BaseResult;
import com.tookbra.bee.sso.uac.params.input.UserInfoInput;
import com.tookbra.bee.sso.uac.params.output.UserInfoOutput;
import com.tookbra.bee.sso.uac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author tookbra
 * @since 2019-03-01
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 分页查询用户
     * @param input
     * @return
     */
    @GetMapping
    public PageResult<UserInfoOutput> pageUserInfo(UserInfoInput input) {
        return PageResult.success(userService.pageUserInfos(input));
    }

    /**
     * 获取用户详情
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public BaseResult getUserInfo(@PathVariable Integer userId) {
        return null;
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping
    public BaseResult saveUser() {
        return null;
    }

    /**
     * 更新用户
     * @param userId
     * @return
     */
    @PutMapping("/{userId}")
    public BaseResult updateUser(Integer userId) {
        return null;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    public BaseResult delUser(Integer userId) {
        return null;
    }
}

