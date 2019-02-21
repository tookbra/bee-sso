package com.tookbra.bee.king.job.service;

import com.tookbra.bee.king.job.BaseTest;
import com.tookbra.bee.king.job.domain.JobInfo;
import com.tookbra.bee.model.page.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tookbra
 * @date 2019/2/21
 * @description
 */
public class JobInfoServiceTest extends BaseTest {

    @Autowired
    JobInfoService jobInfoService;

    @Test
    public void pageByNameTest() {
        jobInfoService.pageByName("", new PageInfo());
    }

    @Test
    public void saveJobTest() {
        JobInfo jobInfo = new JobInfo();
        jobInfo.setJobName("测试作业");
        jobInfo.setJobCron("* 0 0 1 0 0 0 ?");
        jobInfo.setJobActuator(2);
        jobInfoService.saveJob(jobInfo);
    }

    @Test
    public void updateJobTest() {
        JobInfo jobInfo = new JobInfo();
        jobInfo.setId(1);
        jobInfoService.updateJob(jobInfo);
    }

    @Test
    public void removeJobTest() {
        jobInfoService.removeJob(1);
    }
}
