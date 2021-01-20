package com.example.demo.demo.chain;

import java.util.List;

/**
 * Created by @author ymtNSN on 2020/6/23
 */
public class ReceiptHandleChain implements IReceiptHandlerChain {

    private int index = 0;

    private static List<IReceiptHandler> receiptHandlerList;

    static {
        receiptHandlerList = ReceiptHandlerContainer.getReceiptHandlerList();
    }

    @Override
    public void handleReceipt(Receipt receipt) {
        if (receiptHandlerList != null && receiptHandlerList.size() > 0) {
            if (index != receiptHandlerList.size()) {
                IReceiptHandler receiptHandler = receiptHandlerList.get(index++);
                receiptHandler.handleReceipt(receipt, this);
            }
        }
    }

    public static void main(String[] args) {
        List<Receipt> receiptList = null;

        receiptList.forEach(receipt -> {
            ReceiptHandleChain receiptHandleChain = new ReceiptHandleChain();
            receiptHandleChain.handleReceipt(receipt);
        });
    }
}
