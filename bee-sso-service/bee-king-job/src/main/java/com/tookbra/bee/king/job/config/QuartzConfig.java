package com.tookbra.bee.king.job.config;

import com.tookbra.bee.king.job.quartz.QuartzManager;
import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;

/**
 * @author tookbra
 * @date 2019/1/29
 * @description
 */
@Configuration
public class QuartzConfig {


    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setDataSource(dataSource);
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setStartupDelay(30);
        schedulerFactoryBean.setAutoStartup(true);
        return schedulerFactoryBean;
    }

    @Bean
    public QuartzManager quartzManager(SchedulerFactoryBean schedulerFactoryBean) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        QuartzManager quartzManager = new QuartzManager(scheduler);
        return quartzManager;
    }
}
