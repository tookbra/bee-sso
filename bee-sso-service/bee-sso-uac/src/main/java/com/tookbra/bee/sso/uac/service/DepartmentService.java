package com.tookbra.bee.sso.uac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tookbra.bee.sso.uac.domain.Department;
import com.tookbra.bee.sso.uac.params.output.DeptOutput;
import com.tookbra.bee.sso.uac.params.output.DeptTreeOutput;

import java.util.List;

/**
 * <p>
 * 部门 服务类
 * </p>
 *
 * @author tookbra
 * @since 2019-03-04
 */
public interface DepartmentService extends IService<Department> {


    /**
     * 获取部门树
     * @return
     */
    List<DeptTreeOutput> getTree();

    /**
     * 获取部门详情
     * @param id
     * @return
     */
    DeptOutput getDeptById(Integer id);
}
