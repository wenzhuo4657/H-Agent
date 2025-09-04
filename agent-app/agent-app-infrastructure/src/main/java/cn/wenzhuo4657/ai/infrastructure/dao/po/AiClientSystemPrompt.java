package cn.wenzhuo4657.ai.infrastructure.dao.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统提示词配置表(AiClientSystemPrompt)实体类
 *
 * @author makejava
 * @since 2025-09-04 14:47:08
 */
public class AiClientSystemPrompt implements Serializable {
    private static final long serialVersionUID = -86848217489591048L;
/**
     * 主键ID
     */
    private Long id;
/**
     * 提示词ID
     */
    private String promptId;
/**
     * 提示词名称
     */
    private String promptName;
/**
     * 提示词内容
     */
    private String promptContent;
/**
     * 描述
     */
    private String description;
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

    public String getPromptId() {
        return promptId;
    }

    public void setPromptId(String promptId) {
        this.promptId = promptId;
    }

    public String getPromptName() {
        return promptName;
    }

    public void setPromptName(String promptName) {
        this.promptName = promptName;
    }

    public String getPromptContent() {
        return promptContent;
    }

    public void setPromptContent(String promptContent) {
        this.promptContent = promptContent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

