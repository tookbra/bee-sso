package com.tookbra.bee.sso.uac.service;

import com.tookbra.bee.sso.uac.AbstractTest;
import com.tookbra.bee.sso.uac.params.input.UserInfoInput;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tookbra
 * @date 2019/3/4
 * @description
 */
public class UserServiceTest extends AbstractTest {

    @Autowired
    UserService userService;

    @Test
    public void pageUserInfosTest() {
        UserInfoInput input = new UserInfoInput();
        userService.pageUserInfos(input);
    }
}
