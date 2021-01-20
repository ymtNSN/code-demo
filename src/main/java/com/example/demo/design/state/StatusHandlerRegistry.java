package com.example.demo.design.state;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public class StatusHandlerRegistry {

    private static Map<String, AbstractStatusHandler> statusHandlerMap;

    static {
        statusHandlerMap = new ConcurrentHashMap<String, AbstractStatusHandler>();
    }

    private StatusHandlerRegistry() {
    }


    private static String getKey(LeavePermitEnum leavePermitEnum, Status status) {
        return String.format("%s@-@%s", leavePermitEnum.getCode(), status.name());
    }

    /**
     * 注册状态处理类
     *
     * @param leavePermitType 请假类型
     * @param status          请假状态
     * @param statusHandler   状态处理对象
     */
    public static void registryStatusHandler(LeavePermitEnum leavePermitType, Status status, AbstractStatusHandler statusHandler) {
        statusHandlerMap.put(getKey(leavePermitType, status), statusHandler);
    }

    /**
     * 获取状态处理类
     *
     * @param leavePermitType 请假类型
     * @param status          请假状态
     * @return StatusHandler
     */
    public static AbstractStatusHandler acquireStatusHandler(LeavePermitEnum leavePermitType, Status status) {
        return statusHandlerMap.get(getKey(leavePermitType, status));
    }
}
