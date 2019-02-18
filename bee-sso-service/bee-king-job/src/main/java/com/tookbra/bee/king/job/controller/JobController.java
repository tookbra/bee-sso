package com.tookbra.bee.king.job.controller;

import com.tookbra.bee.king.job.quartz.QuartzManager;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tookbra
 * @date 2019/2/1
 * @description
 */
@RestController
@RequestMapping("/jobs")
public class JobController {


    @Autowired
    QuartzManager quartzManager;

    @GetMapping()
    public void addJob() throws SchedulerException {
        quartzManager.addJob("test", "test", "0 0/1 * * * ?");
    }
}
