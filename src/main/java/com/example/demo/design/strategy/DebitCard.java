package com.example.demo.design.strategy;

/**
 * Created by @author ymtNSN on 2020/7/1
 */
public class DebitCard extends AbstractCard {

    public DebitCard() {
        super();
    }

    @Override
    protected void executeTransaction(int cents) {
        System.out.println("doTransaction with Debit:" + cents);
    }

    @Override
    protected String getType() {
        return "debit";
    }
}
