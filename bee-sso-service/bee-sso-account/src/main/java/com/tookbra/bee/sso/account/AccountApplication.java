package com.tookbra.bee.sso.account;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tookbra
 * @date 2019/1/24
 * @description
 */
@ComponentScan(basePackages = { "com.tookbra.bee.patch.*"})
@EnableDiscoveryClient
@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.LOG)
                .sources(AccountApplication.class)
                .run(args);
    }
}
