package com.tookbra.bee.sso.uac.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tookbra.bee.sso.core.utils.TransferUtil;
import com.tookbra.bee.sso.uac.dao.base.DepartmentMapper;
import com.tookbra.bee.sso.uac.domain.Department;
import com.tookbra.bee.sso.uac.params.output.DeptOutput;
import com.tookbra.bee.sso.uac.params.output.DeptTreeOutput;
import com.tookbra.bee.sso.uac.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author tookbra
 * @since 2019-03-04
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Override
    public List<DeptTreeOutput> getTree() {
        return buildDeptTree(this.list(Wrappers.emptyWrapper()));
    }

    @Override
    public DeptOutput getDeptById(Integer id) {
        Department department = this.getById(id);
        DeptOutput deptOutput = new DeptOutput();
        TransferUtil.transfer(department, deptOutput);
        return deptOutput;
    }

    public List<DeptTreeOutput> buildDeptTree(List<Department> list) {
        List<DeptTreeOutput> deptList = new ArrayList<>();
        for (Department department : list) {
            DeptTreeOutput deptTreeOutput = new DeptTreeOutput();
            TransferUtil.transfer(department, deptTreeOutput);
            if(department.getParentId() == 0) {
                deptList.add(deptTreeOutput);
            }
            for(Department dept : list) {
                if(dept.getParentId().equals(deptTreeOutput.getId())) {
                    List<DeptTreeOutput> nodes = deptTreeOutput.getChildren();
                    if(CollectionUtils.isEmpty(nodes)) {
                        nodes = new ArrayList<>();
                    }
                    DeptTreeOutput node = new DeptTreeOutput();
                    TransferUtil.transfer(dept, node);
                    nodes.add(node);
                    deptTreeOutput.setChildren(nodes);
                }
            }
        }
        return deptList;
    }
}
