package com.example.demo.response;

import lombok.Data;

/**
 * Created by @author ymtNSN on 2020/4/15
 */
@Data
public class R<T> {

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    private R() {
    }

    public static R ok(){
        R r = new R();
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    public static R error(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return r;
    }

    public static R setResult(ResultCodeEnum result){
        R r = new R();
        r.setSuccess(result.getSuccess());
        r.setCode(result.getCode());
        r.setMessage(result.getMessage());
        return r;
    }

    public R data(T data){
        this.setData(data);
        return this;
    }

    // 自定义状态信息
    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    // 自定义状态码
    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    // 自定义返回结果
    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }
}
