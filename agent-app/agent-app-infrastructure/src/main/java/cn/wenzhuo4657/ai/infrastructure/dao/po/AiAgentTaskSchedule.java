package cn.wenzhuo4657.ai.infrastructure.dao.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 智能体任务调度配置表(AiAgentTaskSchedule)实体类
 *
 * @author makejava
 * @since 2025-09-04 14:47:08
 */
public class AiAgentTaskSchedule implements Serializable {
    private static final long serialVersionUID = 677314087319780492L;
/**
     * 主键ID
     */
    private Long id;
/**
     * 智能体ID
     */
    private Long agentId;
/**
     * 任务名称
     */
    private String taskName;
/**
     * 任务描述
     */
    private String description;
/**
     * 时间表达式(如: 0/3 * * * * *)
     */
    private String cronExpression;
/**
     * 任务入参配置(JSON格式)
     */
    private String taskParam;
/**
     * 状态(0:无效,1:有效)
     */
    private Integer status;
/**
     * 创建时间
     */
    private Date createTime;
/**
     * 更新时间
     */
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTaskParam() {
        return taskParam;
    }

    public void setTaskParam(String taskParam) {
        this.taskParam = taskParam;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

