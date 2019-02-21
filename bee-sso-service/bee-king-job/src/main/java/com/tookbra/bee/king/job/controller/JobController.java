package com.tookbra.bee.king.job.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tookbra.bee.king.job.domain.JobInfo;
import com.tookbra.bee.king.job.params.input.JobInput;
import com.tookbra.bee.king.job.service.JobInfoService;
import com.tookbra.bee.model.page.PageInfo;
import com.tookbra.bee.model.page.PageResult;
import com.tookbra.bee.model.result.BaseResult;
import com.tookbra.bee.sso.core.utils.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tookbra
 * @date 2019/2/1
 * @description
 */
@RestController
@RequestMapping("/jobs")
public class JobController {


    @Autowired
    JobInfoService jobInfoService;

    /**
     * 分页查询作业
     * @param pageInfo
     */
    @GetMapping
    public PageResult getJobs(@RequestParam("name") String name, PageInfo pageInfo) {
        IPage<JobInfo> result = jobInfoService.pageByName(name, pageInfo);
        return PageResult.success(result);
    }

    /**
     * 添加作业
     * @param input
     * @return
     */
    @PostMapping
    public BaseResult addActuator(JobInput input) {
        JobInfo jobInfo = new JobInfo();
        TransferUtil.transfer(input, jobInfo);
        jobInfoService.saveJob(jobInfo);
        return BaseResult.success("");
    }

    /**
     * 更新作业
     * @param id 作业id
     * @param input
     * @return
     */
    @PutMapping("/{id}")
    public BaseResult updateActuator(@PathVariable Integer id, JobInput input) {
        JobInfo jobActuator = new JobInfo();
        TransferUtil.transfer(input, jobActuator);
        jobActuator.setId(id);
        jobInfoService.updateJob(jobActuator);
        return BaseResult.success("");
    }

    /**
     * 移除作业
     * @param id 作业id
     * @return
     */
    @DeleteMapping("/{id}")
    public BaseResult removeActuator(@PathVariable Integer id) {
        jobInfoService.removeJob(id);
        return BaseResult.success("");
    }
}
