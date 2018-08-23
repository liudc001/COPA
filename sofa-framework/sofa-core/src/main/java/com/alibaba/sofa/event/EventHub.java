package com.alibaba.sofa.event;

import com.alibaba.sofa.dto.event.Event;
import com.alibaba.sofa.exception.InfraException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 事件控制中枢
 * @author shawnzhan.zxy
 * @date 2017/11/20
 */
@Component
@SuppressWarnings("rawtypes")
public class EventHub {

    @Getter
    @Setter
    private Map<Class<? extends Event>, EventHandlerI> eventRepository = new HashMap<>();

    /**
     * 请求参数，返回参数对象映射
     */
    @Getter
    private Map<Class<?>, Class<?>> responseRepository = new HashMap<>();
    
    public EventHandlerI getEventHandler(Class<? extends Event> eventClass) {
        EventHandlerI eventHandlerI = findHandler(eventClass);
        if (eventHandlerI == null) {
            throw new InfraException(eventClass + "is not registered in eventHub, please register first");
        }
        return eventHandlerI;
    }
    private EventHandlerI findHandler(Class<? extends Event> eventClass){
        return eventRepository.get(eventClass);
    }

    /**
     * 注册事件
     * @param eventClz
     * @param executor
     */
    public void register(Class<? extends Event> eventClz, EventHandlerI executor){
        eventRepository.put(eventClz, executor);
    }

}
