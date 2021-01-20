package com.example.demo.design.strategy;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by @author ymtNSN on 2020/7/1
 */
public abstract class AbstractCard implements PaymentMethod {

    static Map<String, PaymentMethod> paymentMethodMap = new ConcurrentHashMap<>();

    public AbstractCard() {
        init();
    }

    @PostConstruct
    public void init() {
        paymentMethodMap.put(getType(), this);
    }

    @Override
    public void pay(int cents) {
        System.out.println("支付方式：" + getType() + "；支付的钱：" + cents);
        executeTransaction(cents);
    }

    protected abstract void executeTransaction(int cents);

    protected abstract String getType();
}
