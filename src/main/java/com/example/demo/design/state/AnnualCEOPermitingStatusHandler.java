package com.example.demo.design.state;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public class AnnualCEOPermitingStatusHandler extends AbstractStatusHandler {
    @Override
    protected void doHandler(LeavePermit leavePermit) {
        System.out.println(String.format("user:%s--ceo审批年休假中--leavePermit status:%s", leavePermit.getUser(), leavePermit.getStatus().getCode()));

    }

    @Override
    protected void after(LeavePermit leavePermit) {
        if (leavePermit.getEvent() == null) {
            //还未审批，状态机结束，等待审批意见
            System.out.println(String.format("user:%s--等待ceo审批--leavePermit status:%s", leavePermit.getUser(), leavePermit.getStatus().getCode()));
            return;
        }
        goNextStatusHandler(leavePermit);
    }

}
