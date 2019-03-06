package com.tookbra.bee.sso.uac;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author tookbra
 * @date 2019/3/1
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UacApplication.class)
@WebAppConfiguration
public abstract class AbstractTest {
}
