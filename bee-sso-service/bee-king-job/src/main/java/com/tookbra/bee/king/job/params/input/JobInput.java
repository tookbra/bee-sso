package com.tookbra.bee.king.job.params.input;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author tookbra
 * @date 2019/2/21
 * @description
 */
@Data
public class JobInput implements Serializable {

    @NotNull
    private String jobName;

    @NotNull
    private String jobCron;

    @NotNull
    private Integer jobActuator;
}
