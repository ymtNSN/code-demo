package com.example.demo.ddd.service.impl;

import com.example.demo.ddd.DP.AuditMessage;
import com.example.demo.ddd.base.SendResult;
import com.example.demo.ddd.service.AuditMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;

public class AuditMessageProducerImpl implements AuditMessageProducer {

    private static final String TOPIC_AUDIT_LOG = "TOPIC_AUDIT_LOG";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public SendResult send(AuditMessage message) {
        String messageBody = message.serialize();
        kafkaTemplate.send(TOPIC_AUDIT_LOG, messageBody);
        return SendResult.success();
    }
}