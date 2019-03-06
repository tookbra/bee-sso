package com.tookbra.bee.sso.uac.dao.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tookbra.bee.sso.uac.params.input.UserInfoInput;
import com.tookbra.bee.sso.uac.params.output.UserInfoOutput;
import org.apache.ibatis.annotations.Param;

/**
 * @author tookbra
 * @date 2019/3/1
 * @description
 */
public interface BizUserMapper {

    IPage<UserInfoOutput> selectUserInfoByPage(Page page, @Param("input") UserInfoInput input);
}
