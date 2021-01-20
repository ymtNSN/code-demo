package com.example.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Created by @author ymtNSN on 2020/9/9
 */
@Service
public class PayService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void paySuccess(String orderId) {
        applicationEventPublisher.publishEvent(new PayEvent(this, orderId));
    }
}
