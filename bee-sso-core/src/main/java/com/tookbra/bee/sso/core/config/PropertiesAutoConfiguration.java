package com.tookbra.bee.sso.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 默认配置
 * @author tookbra
 * @date 2019/2/18
 * @description
 */
@Configuration
@PropertySource("classpath:/mybatis-plus-config.yml")
public class PropertiesAutoConfiguration {
}
