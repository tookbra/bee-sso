package com.tookbra.bee.sso.uac.params.input;

import com.tookbra.bee.model.validation.groups.SaveGroup;
import com.tookbra.bee.model.validation.groups.UpdateGroup;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author tookbra
 * @date 2019/3/5
 * @description
 */
@Data
@ToString
public class MenuInput implements Serializable {
    private static final long serialVersionUID = 581555046091037518L;

    /**
     * 菜单id
     */
    @NotNull(message = "请选择菜单", groups = UpdateGroup.class)
    private Integer menuId;

    /**
     * 父菜单id
     */
    private Integer parentId;

    /**
     * 菜单名称
     */
    @NotNull(message = "请输入菜单名称", groups = {UpdateGroup.class, SaveGroup.class})
    private String name;

    /**
     * 菜单类型 0菜单 1按钮
     */
    @NotNull(message = "请选择菜单类型", groups = {UpdateGroup.class, SaveGroup.class})
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
}
