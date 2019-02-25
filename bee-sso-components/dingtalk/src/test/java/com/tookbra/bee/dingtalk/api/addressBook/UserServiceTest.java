package com.tookbra.bee.dingtalk.api.addressBook;

import com.tookbra.bee.dingtalk.api.DingTalkServiceTest;
import com.tookbra.bee.dingtalk.api.addressBook.impl.UserServiceImpl;
import com.tookbra.bee.dingtalk.bean.input.addressbook.DeptUserInput;
import com.tookbra.bee.dingtalk.bean.input.addressbook.DeptUsersInput;
import com.tookbra.bee.dingtalk.bean.input.addressbook.UserInfoInput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.DeptUserInfoOutput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.DeptUsersOutput;
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
        userInfoInput.setUserId("01023131539572");
        UserInfoOutput userInfoOutput = userService.getUserInfo(userInfoInput);
        System.out.println(userInfoOutput);
    }

    @Test
    public void getDeptMemberTest() {
        DeptUsersInput deptUsersInput = new DeptUsersInput();
        deptUsersInput.setDeptId("1");
        DeptUsersOutput deptUsersOutput = userService.getDeptMember(deptUsersInput);
        System.out.println(deptUsersOutput);
    }

    @Test
    public void getDeptUserInfoListTest() {
        DeptUserInput deptUserInput = new DeptUserInput();
        deptUserInput.setDepartmentId(1);
        DeptUserInfoOutput deptUserInfoOutput = userService.getDeptUserInfoList(deptUserInput);
        System.out.println(deptUserInfoOutput);
    }
}
