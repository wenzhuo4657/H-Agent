package cn.wenzhuo4657.ai.infrastructure.dao;


import cn.wenzhuo4657.ai.infrastructure.dao.po.AiAgentFlowConfig;
import org.apache.ibatis.annotations.Param;
import java.awt.print.Pageable;
import java.util.List;

/**
 * 智能体-客户端关联表(AiAgentFlowConfig)表数据库访问层
 *
 * @author makejava
 * @since 2025-09-04 14:47:38
 */
public interface AiAgentFlowConfigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AiAgentFlowConfig queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param aiAgentFlowConfig 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<AiAgentFlowConfig> queryAllByLimit(AiAgentFlowConfig aiAgentFlowConfig, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param aiAgentFlowConfig 查询条件
     * @return 总行数
     */
    long count(AiAgentFlowConfig aiAgentFlowConfig);

    /**
     * 新增数据
     *
     * @param aiAgentFlowConfig 实例对象
     * @return 影响行数
     */
    int insert(AiAgentFlowConfig aiAgentFlowConfig);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AiAgentFlowConfig> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AiAgentFlowConfig> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AiAgentFlowConfig> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AiAgentFlowConfig> entities);

    /**
     * 修改数据
     *
     * @param aiAgentFlowConfig 实例对象
     * @return 影响行数
     */
    int update(AiAgentFlowConfig aiAgentFlowConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

