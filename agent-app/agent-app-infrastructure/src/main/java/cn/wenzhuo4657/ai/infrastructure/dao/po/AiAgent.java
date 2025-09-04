package cn.wenzhuo4657.ai.infrastructure.dao.po;

import java.util.Date;
import java.io.Serializable;

/**
 * AI智能体配置表(AiAgent)实体类
 *
 * @author makejava
 * @since 2025-09-04 14:47:07
 */
public class AiAgent implements Serializable {
    private static final long serialVersionUID = 236450355995714964L;
/**
     * 主键ID
     */
    private Long id;
/**
     * 智能体ID
     */
    private String agentId;
/**
     * 智能体名称
     */
    private String agentName;
/**
     * 描述
     */
    private String description;
/**
     * 渠道类型(agent，chat_stream)
     */
    private String channel;
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

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

