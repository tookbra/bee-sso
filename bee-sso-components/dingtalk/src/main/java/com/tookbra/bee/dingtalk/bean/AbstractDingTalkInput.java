package com.tookbra.bee.dingtalk.bean;

import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import lombok.Data;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
@Data
public abstract class AbstractDingTalkInput<T extends DingTalkOutput> implements DingTalkInput<T> {

    /**
     * 支持分页查询，与size参数同时设置时才生效，此参数代表偏移量
     */
    private long offset;
    /**
     * 支持分页查询，与offset参数同时设置时才生效，此参数代表分页大小，最大100
     */
    private int size;
    /**
     * 排序规则
     */
    private String order;
}
