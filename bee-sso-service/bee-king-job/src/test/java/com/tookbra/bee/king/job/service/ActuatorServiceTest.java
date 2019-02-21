package com.tookbra.bee.king.job.service;

import com.tookbra.bee.king.job.BaseTest;
import com.tookbra.bee.king.job.domain.JobActuator;
import com.tookbra.bee.model.page.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tookbra
 * @date 2019/2/15
 * @description
 */
public class ActuatorServiceTest extends BaseTest {

    @Autowired
    ActuatorService actuatorService;

    @Test
    public void pageByTitleTest() {
        actuatorService.pageByTitle("", new PageInfo());
    }

    @Test
    public void saveActuatorTest() {
        JobActuator jobActuator = new JobActuator();
        jobActuator.setTitle("测试执行器");
        jobActuator.setAddressType(0);
        actuatorService.saveActuator(jobActuator);
    }

    @Test
    public void updateActuatorTest() {
        JobActuator jobActuator = new JobActuator();
        jobActuator.setId(2);
        actuatorService.updateActuator(jobActuator);
    }

    @Test
    public void removeActuatorTest() {
        JobActuator jobActuator = new JobActuator();
        jobActuator.setId(4);
        actuatorService.removeActuator(jobActuator);
    }
}
