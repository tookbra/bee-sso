package com.tookbra.bee.king.job.quartz;

import com.tookbra.bee.king.job.quartz.QuartzManager;
import org.junit.Before;
import org.junit.Test;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;

/**
 * @author tookbra
 * @date 2019/1/30
 * @description
 */
public class QuartzManagerTest {

    private QuartzManager quartzManager;
    private Scheduler scheduler;

    @Before
    public void init() throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        scheduler = sf.getScheduler();
        quartzManager = new QuartzManager(scheduler);
    }

    @Test
    public void addJobTest() throws SchedulerException, IOException {
        quartzManager.addJob("test", "test", "0 0/1 * * * ?");
        scheduler.start();
        System.in.read();
    }

    @Test
    public void removeTest() throws SchedulerException {
        quartzManager.remove("test", "test");
    }

}
