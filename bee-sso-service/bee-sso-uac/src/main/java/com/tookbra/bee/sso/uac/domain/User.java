package com.tookbra.bee.sso.uac.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author tookbra
 * @since 2019-03-01
 */
@TableName("USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("USER_ID")
    private String userId;

    /**
     * 用户名称
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 邮箱地址
     */
    @TableField("USER_EMAIL")
    private String userEmail;

    /**
     * 手机号
     */
    @TableField("USER_MOBILE")
    private String userMobile;

    /**
     * 是否激活 1是 0否
     */
    @TableField("ACTIVED")
    private Boolean actived;

    /**
     * 头像地址
     */
    @TableField("AVATAR")
    private String avatar;

    /**
     * 工号
     */
    @TableField("JOB_NUMBER")
    private String jobNumber;

    /**
     * 部门ID
     */
    @TableField("DEPT_ID")
    private Integer deptId;

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


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Boolean getActived() {
        return actived;
    }

    public void setActived(Boolean actived) {
        this.actived = actived;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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
        return "User{" +
        "userId=" + userId +
        ", userName=" + userName +
        ", password=" + password +
        ", userEmail=" + userEmail +
        ", userMobile=" + userMobile +
        ", actived=" + actived +
        ", avatar=" + avatar +
        ", jobNumber=" + jobNumber +
        ", deptId=" + deptId +
        ", deleted=" + deleted +
        ", createdTime=" + createdTime +
        ", modifyTime=" + modifyTime +
        ", syncTime=" + syncTime +
        "}";
    }
}
