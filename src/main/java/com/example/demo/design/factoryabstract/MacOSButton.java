package com.example.demo.design.factoryabstract;

/**
 * Created by @author ymtNSN on 2020/10/27
 */
public class MacOSButton implements AbsButton {

    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
