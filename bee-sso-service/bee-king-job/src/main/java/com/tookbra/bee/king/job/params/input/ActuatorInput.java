package com.tookbra.bee.king.job.params.input;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author tookbra
 * @date 2019/2/18
 * @description
 */
@Data
public class ActuatorInput implements Serializable {
    private static final long serialVersionUID = -268096128202726726L;

    /**
     * 执行器名称
     */
    @NotNull(message = "请输入执行器名称")
    private String title;

    /**
     * 0 自动注册 1手动注册
     */
    @NotNull(message = "请选择注册类型")
    private Integer addressType;

    /**
     * 执行器地址
     */
    private String addressList;
}
