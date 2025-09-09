package cn.wenzhuo4657.ai.domain.agent.service.assembly.tree.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DynamicContext {

    /**
     * 0: 异步， 1，同步
     * 默认同步加载
     */
    int nextStrategy=1;




//    上下文数据，类型通过泛型进行自适应
    private Map<String, Object> dataObjects = new HashMap<>();

    public <T> void setValue(String key, T value) {
        dataObjects.put(key, value);
    }

    public <T> T getValue(String key) {
        return (T) dataObjects.get(key);
    }


}
