package com.tookbra.bee.sso.uac.params.output;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author tookbra
 * @date 2019/3/5
 * @description
 */
@Data
@ToString
public class MenuOutput implements Serializable {
    private static final long serialVersionUID = -3924165741411401475L;

    /**
     * 菜单id
     */
    private Integer menuId;

    /**
     * 父菜单id
     */
    private Integer parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单类型 0菜单 1按钮
     */
    private Integer menuType;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图标
     */
    private String icon;

    /**
     * url
     */
    private String path;

    /**
     * 组件
     */
    private String component;

    /**
     * 是否开启路由缓存
     */
    private Boolean keepAlive;

    private List<MenuOutput> children;
}
