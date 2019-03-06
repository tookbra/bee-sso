package com.tookbra.bee.sso.uac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tookbra.bee.sso.uac.domain.User;
import com.tookbra.bee.sso.uac.params.input.UserInfoInput;
import com.tookbra.bee.sso.uac.params.output.UserInfoOutput;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author tookbra
 * @since 2019-03-01
 */
public interface UserService extends IService<User> {

    /**
     * 分页查询
     * @param input
     * @return
     */
    IPage<UserInfoOutput> pageUserInfos(UserInfoInput input);
}
