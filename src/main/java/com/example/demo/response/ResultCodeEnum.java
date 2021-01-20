package com.example.demo.response;

import lombok.Getter;

/**
 * Created by @author ymtNSN on 2020/4/15
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(true, 200, "成功"),
    UNKNOWN_ERROR(false, 201, "未知错误"),
    PARAM_ERROR(false, 202, "参数错误");

    private Boolean success;

    private Integer code;

    private String message;

    ResultCodeEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
