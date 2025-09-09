package cn.wenzhuo4657.ai.domain.agent.service.assembly.tree;

import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo.DynamicContext;
import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo.ResponseParam;
import cn.wenzhuo4657.process.tree.StrategyHandler;
import cn.wenzhuo4657.process.tree.node.RootNode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

/**
 * 该规则树用于加载数据，具体来说，将数据变为spring容器中可使用的bean
 */
@Slf4j
public class AssemblyRoot extends RootNode<ResponseParam, DynamicContext, ResponseParam> {

    @Resource
    private AssemblyRoot loadDataRoot;




    public AssemblyRoot() {
        super(log);
    }

    @Override
    public StrategyHandler<ResponseParam, DynamicContext, ResponseParam> get(ResponseParam requestParameter, DynamicContext dynamicContext) throws Exception {

        return loadDataRoot;
    }
}
