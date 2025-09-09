package cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseParam {

    /**
     * 命令类型 AiAgentEnumVO.getCode
     */
    private String commandType;

    /**
     * 命令索引（clientId、modelId、apiId...）
     */
    private List<String> commandIdList;





}
