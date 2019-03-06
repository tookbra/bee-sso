package com.tookbra.bee.sso.uac.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 角色

 * </p>
 *
 * @author tookbra
 * @since 2019-03-04
 */
@TableName("ROLE")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Integer id;

    /**
     * 角色组ID
     */
    @TableField("ROLE_GROUP_ID")
    private Integer roleGroupId;

    /**
     * 角色组名称
     */
    @TableField("ROLE_GROUP_NNAME")
    private String roleGroupNname;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 描述
     */
    @TableField("DESCRIPTION")
    private byte[] description;

    /**
     * 是否删除 0否 1是
     */
    @TableField("DELETED")
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

    /**
     * 同步时间
     */
    @TableField("SYNC_TIME")
    private LocalDateTime syncTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleGroupId() {
        return roleGroupId;
    }

    public void setRoleGroupId(Integer roleGroupId) {
        this.roleGroupId = roleGroupId;
    }

    public String getRoleGroupNname() {
        return roleGroupNname;
    }

    public void setRoleGroupNname(String roleGroupNname) {
        this.roleGroupNname = roleGroupNname;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
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

    public LocalDateTime getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(LocalDateTime syncTime) {
        this.syncTime = syncTime;
    }

    @Override
    public String toString() {
        return "Role{" +
        "id=" + id +
        ", roleGroupId=" + roleGroupId +
        ", roleGroupNname=" + roleGroupNname +
        ", roleName=" + roleName +
        ", description=" + description +
        ", deleted=" + deleted +
        ", createdTime=" + createdTime +
        ", modifyTime=" + modifyTime +
        ", syncTime=" + syncTime +
        "}";
    }
}
