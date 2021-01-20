package com.example.demo.design.state;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public class AnnualPermitSubmitStatusHandler extends AbstractStatusHandler {

    @Override
    protected void doHandler(LeavePermit leavePermit) {
        System.out.println(String.format("user:%s--提交年休假假单--leavePermit status:%s"
                , leavePermit.getUser(), leavePermit.getStatus().getCode()));

    }
}
