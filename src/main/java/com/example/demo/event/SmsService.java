package com.example.demo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by @author ymtNSN on 2020/9/9
 */
@Service
public class SmsService {

    @EventListener
    public void sendMessage(PayEvent payEvent) {
        System.out.println(">>> 发送短信：" + payEvent.getOrderId());
    }
}
