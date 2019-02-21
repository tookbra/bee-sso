package com.tookbra.bee.king.job.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author tookbra
 * @since 2019-02-21
 */
@TableName("JOB_INFO")
public class JobInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 作业名称
     */
    private String jobName;

    /**
     * 执行器id
     */
    private Integer jobActuator;

    /**
     * cron表达式
     */
    private String jobCron;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除 1删除 0未删除
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime modifyTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getJobActuator() {
        return jobActuator;
    }

    public void setJobActuator(Integer jobActuator) {
        this.jobActuator = jobActuator;
    }

    public String getJobCron() {
        return jobCron;
    }

    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return "JobInfo{" +
        "id=" + id +
        ", jobName=" + jobName +
        ", jobActuator=" + jobActuator +
        ", jobCron=" + jobCron +
        ", remark=" + remark +
        ", deleted=" + deleted +
        ", createdTime=" + createdTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
