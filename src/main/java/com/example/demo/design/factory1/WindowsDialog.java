package com.example.demo.design.factory1;

/**
 * Created by @author ymtNSN on 2020/10/27
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

}
