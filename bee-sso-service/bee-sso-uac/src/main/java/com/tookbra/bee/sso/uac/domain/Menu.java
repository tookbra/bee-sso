package com.tookbra.bee.sso.uac.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author tookbra
 * @since 2019-03-05
 */
@TableName("MENU")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @TableId(value = "MENU_ID", type = IdType.AUTO)
    private Integer menuId;

    /**
     * 父菜单id
     */
    @TableField("PARENT_ID")
    private Integer parentId;

    /**
     * 菜单名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 菜单类型 0菜单 1按钮
     */
    @TableField("MENU_TYPE")
    private Integer menuType;

    /**
     * 排序
     */
    @TableField("SORT")
    private Integer sort;

    /**
     * 图标
     */
    @TableField("ICON")
    private String icon;

    /**
     * url
     */
    @TableField("PATH")
    private String path;

    /**
     * 组件
     */
    @TableField("COMPONENT")
    private String component;

    /**
     * 是否开启路由缓存
     */
    @TableField("KEEP_ALIVE")
    private Boolean keepAlive;

    /**
     * 是否删除 0否 1是
     */
    @TableField("DELETED")
    @TableLogic
    private Boolean deleted;

    /**
     * 创建时间
     */
    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    @TableField(value = "MODIFY_TIME", fill = FieldFill.UPDATE)
    private LocalDateTime modifyTime;


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Menu{" +
        "menuId=" + menuId +
        ", parentId=" + parentId +
        ", name=" + name +
        ", menuType=" + menuType +
        ", sort=" + sort +
        ", icon=" + icon +
        ", path=" + path +
        ", component=" + component +
        ", keepAlive=" + keepAlive +
        ", deleted=" + deleted +
        ", createdTime=" + createdTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
