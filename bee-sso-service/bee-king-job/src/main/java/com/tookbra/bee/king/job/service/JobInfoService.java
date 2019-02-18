package com.tookbra.bee.king.job.service;

import com.tookbra.bee.king.job.quartz.QuartzManager;
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
public class JobInfoService {

    @Autowired
    QuartzManager quartzManager;

    public void addJob() {

    }
}
