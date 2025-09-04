package cn.wenzhuo4657.ai.infrastructure.dao.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 顾问配置表(AiClientAdvisor)实体类
 *
 * @author makejava
 * @since 2025-09-04 14:47:08
 */
public class AiClientAdvisor implements Serializable {
    private static final long serialVersionUID = -96475664090751314L;
/**
     * 主键ID
     */
    private Long id;
/**
     * 顾问ID
     */
    private String advisorId;
/**
     * 顾问名称
     */
    private String advisorName;
/**
     * 顾问类型(PromptChatMemory/RagAnswer/SimpleLoggerAdvisor等)
     */
    private String advisorType;
/**
     * 顺序号
     */
    private Integer orderNum;
/**
     * 扩展参数配置，json 记录
     */
    private String extParam;
/**
     * 状态(0:禁用,1:启用)
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

    public String getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(String advisorId) {
        this.advisorId = advisorId;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getAdvisorType() {
        return advisorType;
    }

    public void setAdvisorType(String advisorType) {
        this.advisorType = advisorType;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getExtParam() {
        return extParam;
    }

    public void setExtParam(String extParam) {
        this.extParam = extParam;
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

