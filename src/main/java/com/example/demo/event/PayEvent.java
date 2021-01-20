package com.example.demo.event;

import lombok.*;
import org.springframework.context.ApplicationEvent;

/**
 * Created by @author ymtNSN on 2020/9/9
 */
@EqualsAndHashCode(callSuper = true)
public class PayEvent extends ApplicationEvent {

    private String orderId;

    public String getOrderId() {
        return this.orderId;
    }

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PayEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }


}
