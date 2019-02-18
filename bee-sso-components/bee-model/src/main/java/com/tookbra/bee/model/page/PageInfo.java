package com.tookbra.bee.model.page;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tookbra
 * @date 2019/2/14
 * @description
 */
@Data
public class PageInfo implements Serializable {

    private static final long serialVersionUID = -3987127393285893441L;

    private int start = 0;

    private int size = 20;
}
