package com.example.demo.design.state;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public class LeavePermitHandler {

    public void handler(LeavePermit leavePermit) {
        getStatusHandler(leavePermit);
    }

    public AbstractStatusHandler getStatusHandler(LeavePermit leavePermit) {
        return StatusHandlerRegistry.acquireStatusHandler(leavePermit.getLeavePermitEnum(), leavePermit.getStatus());
    }
}
