package com.example.demo.design.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author ymtNSN on 2020/7/1
 */
public class Bill {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int getSumCents() {
        return items.stream().mapToInt(Item::getCents).sum();
    }

    public void pay(PaymentMethod paymentMethod) {
        paymentMethod.pay(getSumCents());
    }
}
