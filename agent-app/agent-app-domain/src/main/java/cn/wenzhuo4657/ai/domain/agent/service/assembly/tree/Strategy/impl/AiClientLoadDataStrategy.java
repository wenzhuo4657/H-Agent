package cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.Strategy.impl;

import cn.wenzhuo4657.ai.domain.agent.model.valogj.AiClientVO;
import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.Strategy.LoadStrategy;
import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo.DynamicContext;
import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo.ResponseParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;


@Service("aiClientLoadDataStrategy")
public class AiClientLoadDataStrategy extends LoadStrategy {



    public AiClientLoadDataStrategy(ThreadPoolExecutor threadPoolExecutor) {
        super(threadPoolExecutor);
    }


    @Override
    protected void doApply(ResponseParam requestParameter, DynamicContext dynamicContext) throws Exception {
        log.info("aiClientLoadDataStrategy开始加载");
        List<String> IdList = requestParameter.getCommandIdList();


//       todo 此处要实现并行线程查询，并不破坏同步方法的特性
//        todo  查询什么数据？我的库表没有必要设计那么复杂，这里需要重新设计库表！
        CompletableFuture<List<AiClientVO>> aiClientListFuture = CompletableFuture.supplyAsync(() -> {
            log.info("查询配置数据(ai_client) {}", IdList);
            return repository.AiClientVOByClientIds(IdList);
        }, threadPoolExecutor);

    }
}
