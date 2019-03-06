package com.tookbra.bee.sso.uac.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author tookbra
 * @since 2019-03-04
 */
@TableName("DEPARTMENT")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("DEPT_ID")
    private Integer deptId;

    /**
     * 父部门id
     */
    @TableField("PARENT_ID")
    private Integer parentId;

    /**
     * 部门名称
     */
    @TableField("DEPT_NAME")
    private String deptName;

    /**
     * 排序
     */
    @TableField("DEPT_ORDER")
    private Integer deptOrder;

    /**
     * 是否删除 0否 1是
     */
    @TableField("DELETED")
    private Boolean deleted;

    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    @TableField(value = "MODIFY_TIME", fill = FieldFill.UPDATE)
    private LocalDateTime modifyTime;

    @TableField("SYNC_TIME")
    private LocalDateTime syncTime;


    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptOrder() {
        return deptOrder;
    }

    public void setDeptOrder(Integer deptOrder) {
        this.deptOrder = deptOrder;
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
        return "Department{" +
        "deptId=" + deptId +
        ", parentId=" + parentId +
        ", deptName=" + deptName +
        ", deptOrder=" + deptOrder +
        ", deleted=" + deleted +
        ", createdTime=" + createdTime +
        ", modifyTime=" + modifyTime +
        ", syncTime=" + syncTime +
        "}";
    }
}
