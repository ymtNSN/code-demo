package com.example.demo.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by @author ymtNSN on 2020/6/12
 */
//@Builder
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Demo {
    private String district;

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.district);

        String s = new String("ty");
        SoftReference<String> softReference = new SoftReference<>(s);
        WeakReference<String> weakReference = new WeakReference<>(s);
        String s1 = weakReference.get();

    }
}
