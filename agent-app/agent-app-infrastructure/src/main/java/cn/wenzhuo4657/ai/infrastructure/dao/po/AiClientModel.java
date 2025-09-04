package cn.wenzhuo4657.ai.infrastructure.dao.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 聊天模型配置表(AiClientModel)实体类
 *
 * @author makejava
 * @since 2025-09-04 14:47:08
 */
public class AiClientModel implements Serializable {
    private static final long serialVersionUID = 304502024694138562L;
/**
     * 自增主键ID
     */
    private Long id;
/**
     * 全局唯一模型ID
     */
    private String modelId;
/**
     * 关联的API配置ID
     */
    private String apiId;
/**
     * 模型名称
     */
    private String modelName;
/**
     * 模型类型：openai、deepseek、claude
     */
    private String modelType;
/**
     * 状态：0-禁用，1-启用
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

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
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

