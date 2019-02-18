package com.tookbra.bee.king.job.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tookbra.bee.king.job.dao.JobActuatorMapper;
import com.tookbra.bee.king.job.domain.JobActuator;
import com.tookbra.bee.king.job.params.input.ActuatorInput;
import com.tookbra.bee.model.page.PageInfo;
import com.tookbra.bee.sso.core.utils.TransferUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tookbra
 * @date 2019/2/15
 * @description
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ActuatorService extends ServiceImpl<JobActuatorMapper, JobActuator> {


    /**
     * 分页查询执行器
     * @param title 标题
     * @param pageInfo 分页信息
     * @return {@link IPage}
     */
    public IPage<JobActuator> pageByTitle(String title, PageInfo pageInfo) {
        Page<JobActuator> page = new Page<>(pageInfo.getStart(), pageInfo.getSize());
        IPage<JobActuator> result = super.page(page, new QueryWrapper<JobActuator>().like("title", title));
        return result;
    }

    /**
     * 新增执行器
     * @param jobActuator
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveActuator(JobActuator jobActuator) {
        super.save(jobActuator);
    }

    /**
     * 修改执行器
     * @param jobActuator
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateActuator(JobActuator jobActuator) {
        super.updateById(jobActuator);
    }

    /**
     * 删除执行器
     * @param jobActuator
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteActuator(JobActuator jobActuator) {
        super.removeById(jobActuator);
    }
}
