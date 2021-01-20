package com.example.demo.design.state;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public class AnnualCEOAgreeStatusHandler extends AbstractStatusHandler {

    @Override
    protected void doHandler(LeavePermit leavePermit) {
        System.out.println(String.format("user:%s--ceo同意休年休假--leavePermit status:%s", leavePermit.getUser(), leavePermit.getStatus().getCode()));
    }
}
