package com.example.demo.design.factory1;

/**
 * Created by @author ymtNSN on 2020/10/27
 */
public abstract class Dialog {

    public void renderWindow() {
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}
