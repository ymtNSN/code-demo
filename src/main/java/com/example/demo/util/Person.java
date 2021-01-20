package com.example.demo.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by @author ymtNSN on 2020/4/17
 */
@Getter
@Setter
@ToString
public class Person {

    private int id;

    private int age;

    public Person(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(i);
//        }
//        m1(2);

        new Thread(() -> {
            System.out.println("1、我是ymt1");
        }, "thread1").start();

        new Thread(() -> {
            System.out.println("2、我是ymt2");
        }, "thread2").start();

        new Thread(() -> {
            System.out.println("3、我是ymt3");
        }, "thread3").start();

        System.out.println("3、ymo");

    }

    private static void m1(int i) {
        System.out.println("m1:" + i);
        m2(i);
    }

    private static void m2(int j) {
        j++;
        System.out.println("m2:" + j);
    }
}
