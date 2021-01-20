package com.example.demo.demo;

/**
 * Created by @author ymtNSN on 2020/6/22
 */
@FunctionalInterface
public interface MyFunction {

    void sayHello(String msg);

    boolean equals(Object obj);
//    default void sayHello(String msg){
//        System.out.println(msg);
//    }
}
