package com.tookbra.bee.king.job.controller;

import com.tookbra.bee.king.job.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author tookbra
 * @date 2019/2/21
 * @description
 */
@AutoConfigureMockMvc
public class JobControllerTest extends BaseTest {

    @Autowired
    MockMvc mockMvc;

//    @MockBean
//    private ActuatorService actuatorService;

    @Test
    public void getJobsTest() throws Exception {
        this.mockMvc.perform(get("/jobs").param("name", ""))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addJobTest() throws Exception {
        this.mockMvc.perform(post("/jobs")
                .param("jobName", "测试")
                .param("jobCron", "0 0 0 0 0 0 ?")
                .param("jobActuator", "1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateJobTest() throws Exception {
        this.mockMvc.perform(put("/jobs/2")
                .param("jobName", "测试1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void removeJobTest() throws Exception {
        this.mockMvc.perform(delete("/jobs/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
