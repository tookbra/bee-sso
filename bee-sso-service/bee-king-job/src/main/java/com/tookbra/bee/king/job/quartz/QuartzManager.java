package com.tookbra.bee.king.job.quartz;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Objects;

import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author tookbra
 * @date 2019/1/29
 * @description
 */
public class QuartzManager {

    private static final Logger logger = LoggerFactory.getLogger(QuartzManager.class);

    private Scheduler scheduler;

    public QuartzManager(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /**
     * 添加作业
     * @param name
     * @param group
     * @param cron
     * @return
     * @throws SchedulerException
     */
    public boolean addJob(String name, String group, String cron) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(name, group);
        JobKey jobKey = new JobKey(name, group);

        if(scheduler.checkExists(triggerKey)) {
            return true;
        }

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron)
                .withMisfireHandlingInstructionDoNothing();
        CronTrigger cronTrigger = newTrigger().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();

        JobDetail jobDetail = JobBuilder.newJob(RemoteJobBean.class).withIdentity(jobKey).build();
        Date date = scheduler.scheduleJob(jobDetail, cronTrigger);
        logger.info("next job time={}", date);
        return true;
    }

    /**
     * 更新作业
     * @param name
     * @param group
     * @param cron
     * @return
     * @throws SchedulerException
     */
    public boolean updateJob(String name, String group, String cron) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(name, group);
        if(!scheduler.checkExists(triggerKey)) {
            return true;
        }
        CronTrigger cronTrigger = (CronTrigger)scheduler.getTrigger(triggerKey);
        if(Objects.equals(cronTrigger.getCronExpression(), cron)) {
            return true;
        }

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron)
                .withMisfireHandlingInstructionDoNothing();
        cronTrigger = newTrigger().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
        Date date = scheduler.rescheduleJob(triggerKey, cronTrigger);
        logger.info("next job time={}", date);
        return true;
    }

    /**
     * remove job
     * @param name
     * @param group
     * @throws SchedulerException
     */
    public void remove(String name, String group) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(name, group);

        if (scheduler.checkExists(triggerKey)) {
            scheduler.unscheduleJob(triggerKey);
        }
    }
}
