package cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo;

import lombok.Data;

@Data
public class DynamicContext {

    /**
     * 0: 异步， 1，同步
     * 默认同步加载
     */
    int nextStrategy=1;


}
