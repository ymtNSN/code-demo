package com.example.demo.design.strategy;

/**
 * Created by @author ymtNSN on 2020/7/1
 */
public class CreditCard extends AbstractCard {

    public CreditCard(){
        super();
    }

    @Override
    protected void executeTransaction(int cents) {
        System.out.println("doTransaction with credit:" + cents);
    }

    @Override
    protected String getType() {
        return "credit";
    }
}
