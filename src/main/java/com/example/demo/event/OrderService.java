package com.example.demo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by @author ymtNSN on 2020/9/9
 */
@Service
public class OrderService {

    @EventListener
    public void updateOrderStatus(PayEvent payEvent) {
        String orderId = payEvent.getOrderId();
        System.out.println(">>> 支付成功：" + orderId);
    }
}
