package com.example.demo.design.state;

public enum Event {


    AGREE("agree","同意"),
    DISSAGREE("disagree","不同意"),
    MODIFY("modify","修改"),
    ;

    private String code;
    private String desc;

    Event(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
