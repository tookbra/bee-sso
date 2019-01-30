package com.tookbra.bee.sso.account;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author tookbra
 * @date 2019/1/24
 * @description
 */
@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.LOG)
                .sources(AccountApplication.class)
                .run(args);
    }
}
