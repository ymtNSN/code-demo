package com.example.demo.ddd.service;

import com.example.demo.ddd.DP.AuditMessage;
import com.example.demo.ddd.base.SendResult;

public interface AuditMessageProducer {
    SendResult send(AuditMessage message);
}