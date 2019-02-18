package com.tookbra.bee.sso.core.config;

import com.tookbra.bee.sso.core.interceptor.MethodArgumentInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author tookbra
 * @date 2019/2/18
 * @description
 */
@Configuration
public class WebAutoConfiguration implements WebMvcConfigurer {

    /**
     * controller method argument interceptor
     * @return
     */
    @Bean
    MethodArgumentInterceptor methodArgumentInterceptor() {
        return new MethodArgumentInterceptor();
    }
}
