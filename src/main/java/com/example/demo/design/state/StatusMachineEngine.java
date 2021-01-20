package com.example.demo.design.state;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public class StatusMachineEngine {

    private static EventBus eventBus;

    static {
        eventBus = new EventBus();
    }

    public static void post(LeavePermit leavePermit) {
        eventBus.post(leavePermit);
    }

    public static void addListener(LeavePermitHandler statusHandler) {
        eventBus.register(statusHandler);
    }
}
