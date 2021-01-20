package com.example.demo.design.state;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public class TestDemo {

    public static void main(String[] args) {

        //注册年休假的状态和对应状态的处理类StatusHandler。
        registryAnnualPermitStatusHandler();
        //注册病假的状态和对应状态的处理类StatusHandler。
        registryMedicalPermitStatusHandler();

        LeavePermitHandler leavePermitHandler = new LeavePermitHandler();
        //状态机引擎接受事件处理类
        StatusMachineEngine.addListener(leavePermitHandler);
        //生成假单
        LeavePermit leavePermit = new LeavePermit();
        leavePermit.setLeavePermitEnum(LeavePermitEnum.ANNUAL_LEAVE);
        leavePermit.setStatus(Status.PERMIT_SUBMIT);
        leavePermit.setUser("jettyrun");
        //假单交给引擎去执行
        StatusMachineEngine.post(leavePermit);
        System.out.println("----- 分割线 代表假条需要领导审批了，领导给个通过意见,然后状态机接着走-------");
        leavePermit.setEvent(Event.AGREE);
        StatusMachineEngine.post(leavePermit);
        System.out.println("----- 分割线 代表假条需要ceo审批了，ceo给个通过意见,然后状态机接着走-------");
        leavePermit.setEvent(Event.AGREE);
        StatusMachineEngine.post(leavePermit);
        System.out.println("--->>>>>>>>>end<<<<<<<<-------");
    }

    public static void registryAnnualPermitStatusHandler() {

        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.ANNUAL_LEAVE, Status.PERMIT_SUBMIT, new AnnualPermitSubmitStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.ANNUAL_LEAVE, Status.LEADER_PERMIT_AGREE, new AnnualLeaderAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.ANNUAL_LEAVE, Status.LEADER_PERMIT_DISAGREE, new AnnualLeaderDisAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.ANNUAL_LEAVE, Status.LEADER_PERMIT_MODIFY, new AnnualLeaderPermitModifyStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.ANNUAL_LEAVE, Status.LEADER_PERMITING, new AnnualLeaderPermitingStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.ANNUAL_LEAVE, Status.CEO_PERMIT_AGREE, new AnnualCEOAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.ANNUAL_LEAVE, Status.CEO_PERMIT_DISAGREE, new AnnualCEODisAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.ANNUAL_LEAVE, Status.CEO_PERMIT_MODIFY, new AnnualCEOPermitModifyStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.ANNUAL_LEAVE, Status.CEO_PERMITING, new AnnualCEOPermitingStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.ANNUAL_LEAVE, Status.PERMIT_SUCCESS, new AnnualPermitSuccessStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.ANNUAL_LEAVE, Status.PERMIT_FAIL, new AnnualPermitFailStatusHandler());
    }


    public static void registryMedicalPermitStatusHandler() {

        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.MEDICAL_LEAVE, Status.PERMIT_SUBMIT, new MedicalPermitSubmitStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.MEDICAL_LEAVE, Status.LEADER_PERMIT_AGREE, new MedicalLeaderAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.MEDICAL_LEAVE, Status.LEADER_PERMIT_DISAGREE, new MedicalLeaderDisAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.MEDICAL_LEAVE, Status.LEADER_PERMIT_MODIFY, new MedicalLeaderPermitModifyStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.MEDICAL_LEAVE, Status.LEADER_PERMITING, new MedicalLeaderPermitingStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.MEDICAL_LEAVE, Status.HR_PERMIT_AGREE, new MedicalHrAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.MEDICAL_LEAVE, Status.HR_PERMIT_DISAGREE, new MedicalHrDisAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.MEDICAL_LEAVE, Status.HR_PERMIT_MODIFY, new MedicalHrPermitModifyStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.MEDICAL_LEAVE, Status.HR_PERMITING, new MedicalHrPermitingStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.MEDICAL_LEAVE, Status.PERMIT_SUCCESS, new MedicalPermitSuccessStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitEnum.MEDICAL_LEAVE, Status.PERMIT_FAIL, new MedicalPermitFailStatusHandler());
    }
}
