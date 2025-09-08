package cn.wenzhuo4657.ai.domain.agent.service.assembly.tree;

import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo.DynamicContext;
import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo.ResponseParam;
import cn.wenzhuo4657.process.tree.StrategyHandler;
import cn.wenzhuo4657.process.tree.node.RootNode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
public class Root extends RootNode<ResponseParam, DynamicContext, ResponseParam> {


    public Root() {
        super(log);
    }

    @Override
    public StrategyHandler<ResponseParam, DynamicContext, ResponseParam> get(ResponseParam requestParameter, DynamicContext dynamicContext) throws Exception {

        return DEFAULT;
    }
}
