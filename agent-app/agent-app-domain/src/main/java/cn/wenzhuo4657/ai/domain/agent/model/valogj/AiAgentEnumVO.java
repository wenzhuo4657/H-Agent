package cn.wenzhuo4657.ai.domain.agent.model.valogj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent 通用枚举
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AiAgentEnumVO {

    AI_CLIENT("客户端", "client", "aiClientLoadDataStrategy"),
    ;

    /**
     * 名称
     */
    private String name;

    /**
     * code
     */
    private String code;




    /**
     * 装配数据策略
     */
    private String loadDataStrategy;

    /**
     * 根据code获取对应的枚举
     *
     * @param code 枚举code值
     * @return 对应的枚举，如果未找到则返回null
     */
    public static AiAgentEnumVO getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (AiAgentEnumVO enumVO : AiAgentEnumVO.values()) {
            if (code.equals(enumVO.getCode())) {
                return enumVO;
            }
        }
        throw new RuntimeException("code value " + code + " not exist!");
    }



}
