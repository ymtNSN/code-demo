package com.example.demo.design.state;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
public interface StatusMachine {

    Status getNextStatus(Status status, Event event);
}
