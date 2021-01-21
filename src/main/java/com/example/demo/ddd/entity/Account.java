package com.example.demo.ddd.entity;

import com.example.demo.ddd.DP.Currency;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private AccountId id;
    private AccountNumber accountNumber;
    private UserId userId;
    private Money available;
    private Money dailyLimit;

    public void withdraw(Money money) {
// 转出
    }

    public void deposit(Money money) {
// 转入
    }

    public Currency getCurrency() {
        return null;
    }

    public class AccountId {
        public String getValue() {
            return null;
        }
    }

    public static class AccountNumber {
        public AccountNumber(String targetAccountNumber) {

        }

        public String getValue() {
            return null;
        }
    }

    public static class UserId {
        public UserId(Long sourceUserId) {

        }

        public String getId() {
            return null;
        }
    }

    public static class Money {
        public Money(BigDecimal targetAmount, Currency currency) {

        }

        public Currency getCurrency() {
            return null;
        }
    }
}