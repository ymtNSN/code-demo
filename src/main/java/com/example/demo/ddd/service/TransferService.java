package com.example.demo.ddd.service;

import com.hpcang.commons.base.result.Result;

import java.math.BigDecimal;

/**
 * Created by @author ymtNSN on 2021/1/20
 */
public interface TransferService {
    Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency);
}
