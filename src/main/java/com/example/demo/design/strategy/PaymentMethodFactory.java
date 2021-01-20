package com.example.demo.design.strategy;

/**
 * Created by @author ymtNSN on 2020/7/1
 */
public class PaymentMethodFactory {

    public static PaymentMethod getPaymentMethod(String type) {
        switch (type) {
            case "credit":
                return new CreditCard();
            case "debit":
                return new DebitCard();
            default:
                throw new RuntimeException("can't find type");
        }
    }
}
