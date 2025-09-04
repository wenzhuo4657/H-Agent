package cn.wenzhuo4657.ai.infrastructure.dao.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 智能体-客户端关联表(AiAgentFlowConfig)实体类
 *
 * @author makejava
 * @since 2025-09-04 14:47:08
 */
public class AiAgentFlowConfig implements Serializable {
    private static final long serialVersionUID = -74650616037479397L;
/**
     * 主键ID
     */
    private Long id;
/**
     * 智能体ID
     */
    private Long agentId;
/**
     * 客户端ID
     */
    private Long clientId;
/**
     * 序列号(执行顺序)
     */
    private Integer sequence;
/**
     * 创建时间
     */
    private Date createTime;


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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

