package com.tookbra.bee.king.job.controller;

import com.tookbra.bee.king.job.BaseTest;
import com.tookbra.bee.king.job.service.ActuatorService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author tookbra
 * @date 2019/2/18
 * @description
 */
@AutoConfigureMockMvc
public class ActuatorControllerTest extends BaseTest {

    @Autowired
    MockMvc mockMvc;

//    @MockBean
//    private ActuatorService actuatorService;

    @Test
    public void getActuatorsTest() throws Exception {
        this.mockMvc.perform(get("/actuators").param("title", ""))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
