package com.example.demo.design.state;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public abstract class AbstractStatusHandler implements StatusHandler {

    protected void before(LeavePermit leavePermit) {

    }

    @Override
    public void handle(LeavePermit leavePermit) {
        before(leavePermit);
        doHandler(leavePermit);
        after(leavePermit);
    }

    protected abstract void doHandler(LeavePermit leavePermit);

    protected void after(LeavePermit leavePermit) {
        goNextStatusHandler(leavePermit);
    }

    protected void goNextStatusHandler(LeavePermit leavePermit) {
        leavePermit.setStatus(StatusMachineFactory.getStatusMachine(leavePermit.getLeavePermitEnum()).getNextStatus(leavePermit.getStatus(), leavePermit.getEvent()));
        StatusMachineEngine.post(leavePermit);
    }
}
