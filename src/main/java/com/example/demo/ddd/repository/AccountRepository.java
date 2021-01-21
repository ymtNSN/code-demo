package com.example.demo.ddd.repository;

import com.example.demo.ddd.entity.Account;

public interface AccountRepository {

    Account find(Account.AccountId id);

    Account find(Account.AccountNumber accountNumber);

    Account find(Account.UserId userId);

    Account save(Account account);
}