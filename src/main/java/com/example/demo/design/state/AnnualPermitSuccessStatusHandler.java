package com.example.demo.design.state;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public class AnnualPermitSuccessStatusHandler extends AbstractStatusHandler {

    @Override
    protected void doHandler(LeavePermit leavePermit){
        System.out.println(String.format("user:%s--请年休假假成功--leavePermit status:%s %s",leavePermit.getUser(),leavePermit.getStatus().getCode(),leavePermit.getStatus().getDesc()));
    }
    @Override
    protected void after(LeavePermit leavePermit){
    }
}
