package com.tookbra.bee.dingtalk.annoatation;

import java.lang.annotation.*;

/**
 * @author tookbra
 * @date 2019/1/10
 * @description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Spi {

    /**
     *
     * @return
     */
    String value() default "";
}
