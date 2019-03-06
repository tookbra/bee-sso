package com.tookbra.bee.sso.uac.dao.biz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tookbra.bee.sso.uac.AbstractTest;
import com.tookbra.bee.sso.uac.params.input.UserInfoInput;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tookbra
 * @date 2019/3/1
 * @description
 */
public class BizUserMapperTest extends AbstractTest {

    @Autowired
    BizUserMapper bizUserMapper;

    @Test
    public void selectUserInfoByPageTest() {
        bizUserMapper.selectUserInfoByPage(new Page(), new UserInfoInput());
    }
}
