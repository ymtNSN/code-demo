package com.example.demo.demo.chain;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by @author ymtNSN on 2020/6/23
 */
public class Mt210ReceiptHandler implements IReceiptHandler {
    @Override
    public void handleReceipt(Receipt receipt, IReceiptHandlerChain chain) {
        if (StringUtils.equals("MT2101", receipt.getType())) {
            System.out.println("MT210：" + receipt.getMessage());
        } else {
            chain.handleReceipt(receipt);
        }
    }
}
