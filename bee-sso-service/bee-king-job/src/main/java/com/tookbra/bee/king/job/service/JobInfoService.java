package com.tookbra.bee.king.job.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tookbra.bee.king.job.dao.JobInfoMapper;
import com.tookbra.bee.king.job.domain.JobInfo;
import com.tookbra.bee.king.job.quartz.QuartzManager;
import com.tookbra.bee.model.exception.BizException;
import com.tookbra.bee.model.page.PageInfo;
import com.tookbra.bee.sso.core.utils.TransferUtil;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tookbra
 * @date 2019/2/14
 * @description
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class JobInfoService extends ServiceImpl<JobInfoMapper, JobInfo> {

    @Autowired
    QuartzManager quartzManager;

    /**
     * 分页查询作业
     * @param jobName 标题
     * @param pageInfo 分页信息
     * @return {@link IPage}
     */
    public IPage<JobInfo> pageByName(String jobName, PageInfo pageInfo) {
        Page<JobInfo> page = new Page<>(pageInfo.getStart(), pageInfo.getSize());
        IPage<JobInfo> result = super.page(page, new QueryWrapper<JobInfo>().like("job_name", jobName));
        return result;
    }

    /**
     * 新增作业
     * @param jobInfo
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveJob(JobInfo jobInfo) {
        super.save(jobInfo);
    }

    /**
     * 修改作业
     * @param jobInfo
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateJob(JobInfo jobInfo) {
        JobInfo newJob = super.getById(jobInfo.getId());
        TransferUtil.transfer(jobInfo, newJob);
        super.updateById(newJob);

        try {
            quartzManager.updateJob(newJob.getJobName(), newJob.getJobActuator().toString(), newJob.getJobCron());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 移除作业
     * @param jobId
     */
    @Transactional(rollbackFor = Exception.class)
    public void removeJob(Integer jobId) {
        JobInfo jobInfo = super.getById(jobId);
        if(jobInfo == null) {
            throw new BizException("");
        }
        super.removeById(jobId);
        try {
            quartzManager.remove(jobInfo.getJobName(), jobInfo.getJobActuator().toString());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
