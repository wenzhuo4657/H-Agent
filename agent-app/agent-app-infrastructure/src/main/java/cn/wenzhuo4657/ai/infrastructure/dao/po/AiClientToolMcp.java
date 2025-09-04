package cn.wenzhuo4657.ai.infrastructure.dao.po;

import java.util.Date;
import java.io.Serializable;

/**
 * MCP客户端配置表(AiClientToolMcp)实体类
 *
 * @author makejava
 * @since 2025-09-04 14:47:08
 */
public class AiClientToolMcp implements Serializable {
    private static final long serialVersionUID = 894433368327689412L;
/**
     * 主键ID
     */
    private Long id;
/**
     * MCP名称
     */
    private String mcpId;
/**
     * MCP名称
     */
    private String mcpName;
/**
     * 传输类型(sse/stdio)
     */
    private String transportType;
/**
     * 传输配置(sse/stdio)
     */
    private String transportConfig;
/**
     * 请求超时时间(分钟)
     */
    private Integer requestTimeout;
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

    public String getMcpId() {
        return mcpId;
    }

    public void setMcpId(String mcpId) {
        this.mcpId = mcpId;
    }

    public String getMcpName() {
        return mcpName;
    }

    public void setMcpName(String mcpName) {
        this.mcpName = mcpName;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getTransportConfig() {
        return transportConfig;
    }

    public void setTransportConfig(String transportConfig) {
        this.transportConfig = transportConfig;
    }

    public Integer getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(Integer requestTimeout) {
        this.requestTimeout = requestTimeout;
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

