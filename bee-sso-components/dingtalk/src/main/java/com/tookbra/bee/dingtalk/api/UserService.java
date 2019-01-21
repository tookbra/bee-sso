package com.tookbra.bee.dingtalk.api;

import com.tookbra.bee.dingtalk.bean.input.addressbook.DeptUserInput;
import com.tookbra.bee.dingtalk.bean.input.addressbook.DeptUsersInput;
import com.tookbra.bee.dingtalk.bean.input.addressbook.UserInfoInput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.DeptUserInfoOutput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.DeptUsersOutput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.UserInfoOutput;


/**
 * 用户管理接口
 * @author tookbra
 * @date 2019/1/18
 * @description
 */
public interface UserService  {

    String USER_INFO_URL = "https://oapi.dingtalk.com/user/get";

    String DEPT_USERS_URL = "https://oapi.dingtalk.com/user/getDeptMember";

    String DEPT_USER_INFO_URL = "https://oapi.dingtalk.com/user/listbypage";

    /**
     * 获取用户详情
     * https://oapi.dingtalk.com/user/get?access_token=ACCESS_TOKEN&userid=zhangsan
     * @param userInfoInput
     * @return
     */
    UserInfoOutput getUserInfo(UserInfoInput userInfoInput);

    /**
     * 获取部门用户userId列表
     * https://oapi.dingtalk.com/user/getDeptMember?access_token=ACCESS_TOKEN&deptId=1
     * @param deptUsersInput
     * @return
     */
    DeptUsersOutput getDeptMember(DeptUsersInput deptUsersInput);

    /**
     * 获取部门用户详情
     * https://oapi.dingtalk.com/user/listbypage?access_token=ACCESS_TOKEN&department_id=1
     * @param deptUserInput
     * @return
     */
    DeptUserInfoOutput getDeptUserInfoList(DeptUserInput deptUserInput);
}
