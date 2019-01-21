package com.tookbra.bee.dingtalk.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
@Data
@ToString
public class PageInfo<T> {

    /**
     * 是否还有更多数据
     */
    private boolean hasMore;
    /**
     *
     */
    private List<T> list;
}
