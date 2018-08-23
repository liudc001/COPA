package com.alibaba.sofa.command;

import com.alibaba.sofa.dto.Command;
import com.alibaba.sofa.dto.Response;

/**
 * 
 * CommandBus
 * 
 * @author fulan.zjf 2017年10月21日 下午11:00:58
 */
public interface CommandBusI {

    /**
     * Send command to CommandBus, then the command will be executed by CommandExecutor
     * 
     * @param cmd or Query
     * @return Response
     */
    Response send(Command cmd);
}
