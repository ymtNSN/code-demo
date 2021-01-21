package com.example.demo.ddd.DP;

import com.example.demo.ddd.entity.Account;

import java.io.Serializable;

/**
 * Created by @author ymtNSN on 2021/1/20
 */
public class AuditMessage implements Serializable {
    public AuditMessage(Account sourceAccount, Account targetAccount, Account.Money targetMoney) {

    }

    public String serialize() {
        return null;
    }
}
