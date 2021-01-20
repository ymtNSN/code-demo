package com.example.demo.design.state;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public class AnnualLeaderAgreeStatusHandler extends AbstractStatusHandler {
    @Override
    protected void doHandler(LeavePermit leavePermit) {
        System.out.println(String.format("user:%s--直线领导同意请年休假--leavePermit status:%s"
                , leavePermit.getUser(), leavePermit.getStatus().getCode()));
    }
}
