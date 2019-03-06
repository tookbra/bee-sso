package com.tookbra.bee.sso.uac;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author tookbra
 * @date 2019/2/27
 * @description
 */
@SpringBootApplication
public class UacApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.LOG)
                .sources(UacApplication.class)
                .run(args);
    }
}
