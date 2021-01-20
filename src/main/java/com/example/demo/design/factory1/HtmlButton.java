package com.example.demo.design.factory1;

/**
 * Created by @author ymtNSN on 2020/10/27
 */
public class HtmlButton implements Button {

    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
