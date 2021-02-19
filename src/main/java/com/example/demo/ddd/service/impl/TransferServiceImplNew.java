package com.example.demo.ddd.service.impl;

import com.example.demo.ddd.DP.AuditMessage;
import com.example.demo.ddd.DP.Currency;
import com.example.demo.ddd.DP.ExchangeRate;
import com.example.demo.ddd.entity.Account;
import com.example.demo.ddd.repository.AccountRepository;
import com.example.demo.ddd.service.AccountTransferService;
import com.example.demo.ddd.service.AuditMessageProducer;
import com.example.demo.ddd.service.ExchangeRateService;
import com.example.demo.ddd.service.TransferService;
//import com.hpcang.commons.base.result.Result;

import java.math.BigDecimal;

public class TransferServiceImplNew implements TransferService {
    private AccountRepository accountRepository;
    private AuditMessageProducer auditMessageProducer;
    private ExchangeRateService exchangeRateService;
    private AccountTransferService accountTransferService;

    @Override
    public Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {
        // 参数校验
        Account.Money targetMoney = new Account.Money(targetAmount, new Currency(targetCurrency));
        // 读数据
        Account sourceAccount = accountRepository.find(new Account.UserId(sourceUserId));
        Account targetAccount = accountRepository.find(new Account.AccountNumber(targetAccountNumber));
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());
        // 业务逻辑
        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);
        // 保存数据
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
        // 发送审计消息
        AuditMessage message = new AuditMessage(sourceAccount, targetAccount, targetMoney);
        auditMessageProducer.send(message);
        return Result.success(true, "");
    }
}