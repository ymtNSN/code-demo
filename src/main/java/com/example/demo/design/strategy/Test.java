package com.example.demo.design.strategy;

/**
 * Created by @author ymtNSN on 2020/7/1
 */
public class Test {
    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.addItem(new Item("java", 500));
        bill.addItem(new Item("python", 400));

        PaymentMethodFactory.getPaymentMethod("debit");
        PaymentMethodFactory.getPaymentMethod("credit");


        bill.pay(AbstractCard.paymentMethodMap.get("debit"));
    }
}
