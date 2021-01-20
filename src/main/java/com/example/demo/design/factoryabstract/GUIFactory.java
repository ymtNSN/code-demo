package com.example.demo.design.factoryabstract;

import com.example.demo.design.factory1.Button;

/**
 * Created by @author ymtNSN on 2020/10/27
 */
public interface GUIFactory {

    AbsButton createButton();

    Checkbox createCheckbox();
}
