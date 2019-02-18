package com.tookbra.bee.sso.core.utils;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author tookbra
 * @date 2019/2/18
 * @description
 */
@Data
public class ParamInput implements Serializable {

    @NotNull(message = "name is not empty")
    private String name;

    @NotNull(message = "age is not empty")
    @Range(min = 18, max = 99, message = "age between 18 and 99")
    private Integer age;
}
