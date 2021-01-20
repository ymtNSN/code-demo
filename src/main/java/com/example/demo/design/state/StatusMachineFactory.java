package com.example.demo.design.state;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public class StatusMachineFactory {

    private StatusMachineFactory(){}

    public static StatusMachine getStatusMachine(LeavePermitEnum leavePermitEnum){
        switch (leavePermitEnum){
            case MEDICAL_LEAVE:
                return new MedicalLeaveStatusMachine();
            case ANNUAL_LEAVE:
                return new AnnualLeaveStatusMachine();
            default:
                throw new RuntimeException("未知类型");
        }
    }


}
