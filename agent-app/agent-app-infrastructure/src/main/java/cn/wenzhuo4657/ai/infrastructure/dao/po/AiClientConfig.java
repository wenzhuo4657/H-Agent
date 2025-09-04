package cn.wenzhuo4657.ai.infrastructure.dao.po;

import java.util.Date;
import java.io.Serializable;

/**
 * AI客户端统一关联配置表(AiClientConfig)实体类
 *
 * @author makejava
 * @since 2025-09-04 14:47:08
 */
public class AiClientConfig implements Serializable {
    private static final long serialVersionUID = -26685197317527006L;
/**
     * 主键ID
     */
    private Long id;
/**
     * 源类型（model、client）
     */
    private String sourceType;
/**
     * 源ID（如 chatModelId、chatClientId 等）
     */
    private String sourceId;
/**
     * 目标类型（model、client）
     */
    private String targetType;
/**
     * 目标ID（如 openAiApiId、chatModelId、systemPromptId、advisorId 等）
     */
    private String targetId;
/**
     * 扩展参数（JSON格式）
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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
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

