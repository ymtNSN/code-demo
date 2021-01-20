package com.example.demo.demo.chain;

/**
 * Created by @author ymtNSN on 2020/6/23
 */
public interface IReceiptHandler {

    void handleReceipt(Receipt receipt,IReceiptHandlerChain chain);
}
