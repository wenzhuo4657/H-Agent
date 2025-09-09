package cn.wenzhuo4657.ai.domain.agent.service.assembly.tree;

import cn.wenzhuo4657.ai.domain.agent.model.valogj.AiAgentEnumVO;
import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.Strategy.LoadStrategy;
import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo.DynamicContext;
import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo.ResponseParam;
import cn.wenzhuo4657.process.tree.AbstractStrategyRouter;
import cn.wenzhuo4657.process.tree.StrategyHandler;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoadDataNode extends AbstractStrategyRouter<ResponseParam, DynamicContext, ResponseParam> {
    Map<String, LoadStrategy> loadStrategyMap;

    public LoadDataNode(Map<String, LoadStrategy> loadStrategyMap) {
        this.loadStrategyMap = loadStrategyMap;
    }
    @Override
    public ResponseParam apply(ResponseParam requestParameter, DynamicContext dynamicContext) throws Exception {

//        1,获取vo类型，找到commandType对应的配置
        AiAgentEnumVO vo = AiAgentEnumVO.getByCode(requestParameter.getCommandType());

//        2，根据vo配置找到加载策略
        LoadStrategy loadStrategy = loadStrategyMap.get(vo.getLoadDataStrategy());

//        3,加载配置
        loadStrategy.apply(requestParameter,dynamicContext);

        return router(requestParameter,dynamicContext);
    }

    @Override
    public StrategyHandler<ResponseParam, DynamicContext, ResponseParam> get(ResponseParam requestParameter, DynamicContext dynamicContext) throws Exception {
        return null;
    }
}
