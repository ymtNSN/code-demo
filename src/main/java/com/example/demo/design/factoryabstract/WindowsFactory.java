package com.example.demo.design.factoryabstract;

/**
 * Created by @author ymtNSN on 2020/10/27
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public AbsButton createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
