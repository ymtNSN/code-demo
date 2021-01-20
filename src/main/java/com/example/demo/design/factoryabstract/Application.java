package com.example.demo.design.factoryabstract;

/**
 * Created by @author ymtNSN on 2020/10/27
 */
public class Application {

    private AbsButton button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

}
