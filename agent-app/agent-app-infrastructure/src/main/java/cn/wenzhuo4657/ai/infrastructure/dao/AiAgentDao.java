package cn.wenzhuo4657.ai.infrastructure.dao;


import cn.wenzhuo4657.ai.infrastructure.dao.po.AiAgent;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;

/**
 * AI智能体配置表(AiAgent)表数据库访问层
 *
 * @author makejava
 * @since 2025-09-04 14:47:38
 */
public interface AiAgentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AiAgent queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param aiAgent 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<AiAgent> queryAllByLimit(AiAgent aiAgent, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param aiAgent 查询条件
     * @return 总行数
     */
    long count(AiAgent aiAgent);

    /**
     * 新增数据
     *
     * @param aiAgent 实例对象
     * @return 影响行数
     */
    int insert(AiAgent aiAgent);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AiAgent> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AiAgent> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AiAgent> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AiAgent> entities);

    /**
     * 修改数据
     *
     * @param aiAgent 实例对象
     * @return 影响行数
     */
    int update(AiAgent aiAgent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

