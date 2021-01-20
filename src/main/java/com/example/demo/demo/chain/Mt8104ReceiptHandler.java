package com.example.demo.demo.chain;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by @author ymtNSN on 2020/6/23
 */
public class Mt8104ReceiptHandler implements IReceiptHandler {
    @Override
    public void handleReceipt(Receipt receipt, IReceiptHandlerChain chain) {
        if (StringUtils.equals("MT8104", receipt.getType())) {
            System.out.println("MT8104：" + receipt.getMessage());
        } else {
            chain.handleReceipt(receipt);
        }
    }
}
