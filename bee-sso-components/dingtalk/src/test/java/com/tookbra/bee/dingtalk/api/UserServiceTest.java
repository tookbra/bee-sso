package com.tookbra.bee.dingtalk.api;

import com.tookbra.bee.dingtalk.api.impl.UserServiceImpl;
import com.tookbra.bee.dingtalk.bean.input.addressbook.DeptUserInput;
import com.tookbra.bee.dingtalk.bean.input.addressbook.DeptUsersInput;
import com.tookbra.bee.dingtalk.bean.input.addressbook.UserInfoInput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.DeptUserInfoOutput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.UserInfoOutput;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
public class UserServiceTest extends DingTalkServiceTest {

    private UserService userService;

    @Before
    public void init() {
        super.init();
        userService = new UserServiceImpl(super.getDingTalkService());
    }

    @Test
    public void getUserInfoTest() {
        UserInfoInput userInfoInput = new UserInfoInput();
        userInfoInput.setUserId("01053211253410");
        UserInfoOutput userInfoOutput = userService.getUserInfo(userInfoInput);
        System.out.println(userInfoOutput);
    }

    @Test
    public void getDeptMemberTest() {
        DeptUsersInput deptUsersInput = new DeptUsersInput();
        deptUsersInput.setDeptId("2");
        userService.getDeptMember(deptUsersInput);
    }

    @Test
    public void getDeptUserInfoListTest() {
        DeptUserInput deptUserInput = new DeptUserInput();
        deptUserInput.setDepartmentId(1);
        DeptUserInfoOutput deptUserInfoOutput = userService.getDeptUserInfoList(deptUserInput);
        System.out.println(deptUserInfoOutput);
    }
}
