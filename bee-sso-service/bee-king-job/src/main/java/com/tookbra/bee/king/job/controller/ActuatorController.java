package com.tookbra.bee.king.job.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tookbra.bee.king.job.domain.JobActuator;
import com.tookbra.bee.king.job.params.input.ActuatorInput;
import com.tookbra.bee.king.job.service.ActuatorService;
import com.tookbra.bee.model.page.PageInfo;
import com.tookbra.bee.model.page.PageResult;
import com.tookbra.bee.model.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tookbra
 * @date 2019/2/14
 * @description
 */
@RestController
@RequestMapping("/actuators")
public class ActuatorController {

    @Autowired
    ActuatorService actuatorService;

    /**
     * 分页查询执行器
     * @param pageInfo
     */
    @GetMapping
    public PageResult getActuators(@RequestParam("title") String title, PageInfo pageInfo) {
        IPage<JobActuator> result = actuatorService.pageByTitle(title, pageInfo);
        return PageResult.success(result);
    }

    /**
     * 添加执行器
     * @param input
     * @return
     */
    @PostMapping
    public BaseResult addActuator(ActuatorInput input) {
        return null;

    }
}
