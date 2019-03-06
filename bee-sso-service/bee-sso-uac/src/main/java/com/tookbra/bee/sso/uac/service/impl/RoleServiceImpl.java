package com.tookbra.bee.sso.uac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tookbra.bee.model.page.PageInfo;
import com.tookbra.bee.sso.core.utils.TransferUtil;
import com.tookbra.bee.sso.uac.dao.base.RoleMapper;
import com.tookbra.bee.sso.uac.domain.Role;
import com.tookbra.bee.sso.uac.params.output.RoleOutput;
import com.tookbra.bee.sso.uac.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色
 服务实现类
 * </p>
 *
 * @author tookbra
 * @since 2019-03-04
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public IPage<RoleOutput> pageRole(PageInfo pageInfo) {
        Page<Role> page = new Page<>(pageInfo.getStart(), pageInfo.getSize());
        IPage<Role> roles = this.page(page, Wrappers.emptyWrapper());
        List<RoleOutput> roleOutputs = TransferUtil.transferList(roles.getRecords(), RoleOutput.class);
        IPage<RoleOutput> result = new Page<>();
        result.setTotal(roles.getTotal());
        result.setRecords(roleOutputs);
        return result;
    }
}
