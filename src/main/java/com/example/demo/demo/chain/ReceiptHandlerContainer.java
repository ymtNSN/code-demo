package com.example.demo.demo.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author ymtNSN on 2020/6/23
 */
public class ReceiptHandlerContainer {

    public static List<IReceiptHandler> getReceiptHandlerList() {

        List<IReceiptHandler> receiptHandlerList = new ArrayList<>();
        receiptHandlerList.add(new Mt210ReceiptHandler());
        receiptHandlerList.add(new Mt8104ReceiptHandler());

        return receiptHandlerList;
    }
}
