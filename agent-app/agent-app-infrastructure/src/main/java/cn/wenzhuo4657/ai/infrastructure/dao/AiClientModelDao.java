package cn.wenzhuo4657.ai.infrastructure.dao;


import cn.wenzhuo4657.ai.infrastructure.dao.po.AiClientModel;
import org.apache.ibatis.annotations.Param;
import java.awt.print.Pageable;
import java.util.List;

/**
 * 聊天模型配置表(AiClientModel)表数据库访问层
 *
 * @author makejava
 * @since 2025-09-04 14:47:39
 */
public interface AiClientModelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AiClientModel queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param aiClientModel 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<AiClientModel> queryAllByLimit(AiClientModel aiClientModel, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param aiClientModel 查询条件
     * @return 总行数
     */
    long count(AiClientModel aiClientModel);

    /**
     * 新增数据
     *
     * @param aiClientModel 实例对象
     * @return 影响行数
     */
    int insert(AiClientModel aiClientModel);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AiClientModel> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AiClientModel> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AiClientModel> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AiClientModel> entities);

    /**
     * 修改数据
     *
     * @param aiClientModel 实例对象
     * @return 影响行数
     */
    int update(AiClientModel aiClientModel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

