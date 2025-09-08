package cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.Strategy;

import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo.DynamicContext;
import cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo.ResponseParam;
import cn.wenzhuo4657.process.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * 数据加载流程定义， 异步 or 同步
 */

@Slf4j
public abstract class LoadStrategy implements StrategyHandler<ResponseParam, DynamicContext, ResponseParam> {


    private  ThreadPoolExecutor threadPoolExecutor;
    public LoadStrategy(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor=threadPoolExecutor;
    }

    @Override
    public ResponseParam apply(ResponseParam requestParameter, DynamicContext dynamicContext) throws Exception {
        if (dynamicContext.getNextStrategy()==1){
            dynamicContext.setNextStrategy(0);
            return this.apply(requestParameter,dynamicContext);
        }
        threadPoolExecutor.execute(()->{
            try {
                this.apply(requestParameter,dynamicContext);
            } catch (Exception e) {
               log.error("数据加载异常",e);
            }
        });
        return null;
    }
}
