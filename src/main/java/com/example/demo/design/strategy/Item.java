package com.example.demo.design.strategy;

import lombok.Data;

/**
 * Created by @author ymtNSN on 2020/7/1
 */
@Data
public class Item {

    private String des;

    private int cents;

    public Item(String des, int cents) {
        this.cents = cents;
        this.des = des;
    }
}
