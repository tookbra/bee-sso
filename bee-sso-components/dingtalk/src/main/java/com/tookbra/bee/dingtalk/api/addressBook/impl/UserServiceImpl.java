package com.tookbra.bee.dingtalk.api.addressBook.impl;

import com.tookbra.bee.dingtalk.api.DingTalkService;
import com.tookbra.bee.dingtalk.api.addressBook.UserService;
import com.tookbra.bee.dingtalk.bean.input.addressbook.DeptUserInput;
import com.tookbra.bee.dingtalk.bean.input.addressbook.DeptUsersInput;
import com.tookbra.bee.dingtalk.bean.input.addressbook.UserInfoInput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.DeptUserInfoOutput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.DeptUsersOutput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.UserInfoOutput;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
public class UserServiceImpl implements UserService {

    private DingTalkService dingTalkService;

    public UserServiceImpl(DingTalkService dingTalkService) {
        this.dingTalkService = dingTalkService;
    }

    @Override
    public UserInfoOutput getUserInfo(UserInfoInput userInfoInput) {
        return this.dingTalkService.get(UserService.USER_INFO_URL, userInfoInput);
    }

    @Override
    public DeptUsersOutput getDeptMember(DeptUsersInput deptUsersInput) {
        return this.dingTalkService.get(UserService.DEPT_USERS_URL, deptUsersInput);
    }

    @Override
    public DeptUserInfoOutput getDeptUserInfoList(DeptUserInput deptUserInput) {
        return this.dingTalkService.get(UserService.DEPT_USER_INFO_URL, deptUserInput);
    }
}
