package com.tookbra.bee.sso.uac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tookbra.bee.sso.uac.dao.base.UserMapper;
import com.tookbra.bee.sso.uac.dao.biz.BizUserMapper;
import com.tookbra.bee.sso.uac.domain.User;
import com.tookbra.bee.sso.uac.params.input.UserInfoInput;
import com.tookbra.bee.sso.uac.params.output.UserInfoOutput;
import com.tookbra.bee.sso.uac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author tookbra
 * @since 2019-03-01
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    BizUserMapper bizUserMapper;

    @Override
    public IPage<UserInfoOutput> pageUserInfos(UserInfoInput input) {
        Page<User> page = new Page<>(input.getStart(), input.getSize());
        IPage<UserInfoOutput> users = bizUserMapper.selectUserInfoByPage(page, input);
        return users;
    }

}
