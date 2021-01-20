package com.example.demo.design.state;

import lombok.Getter;

/**
 * @author ymtnsn
 */

@Getter
public enum LeavePermitEnum {

    /**
     * 请假类型
     */
    ANNUAL_LEAVE("annual_leave", "年休假 "),
    CASUAL_LEAVE("casual_leave", "事假"),
    MEDICAL_LEAVE("medical_leave", "病假"),
    MARRIAGE_LEAVE("marriage_leave", "婚假"),
    ;

    private String code;
    private String desc;

    LeavePermitEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
