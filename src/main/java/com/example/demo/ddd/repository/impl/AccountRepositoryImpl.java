package com.example.demo.ddd.repository.impl;

import com.example.demo.ddd.builder.AccountBuilder;
import com.example.demo.ddd.dao.DO.AccountDO;
import com.example.demo.ddd.dao.mapper.AccountMapper;
import com.example.demo.ddd.entity.Account;
import com.example.demo.ddd.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ymtnsn
 */
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private AccountMapper accountDAO;
    @Autowired
    private AccountBuilder accountBuilder;

    @Override
    public Account find(Account.AccountId id) {
        AccountDO accountDO = accountDAO.selectById(id.getValue());
        return accountBuilder.toAccount(accountDO);
    }

    @Override
    public Account find(Account.AccountNumber accountNumber) {
        AccountDO accountDO =
                accountDAO.selectByAccountNumber(accountNumber.getValue());
        return accountBuilder.toAccount(accountDO);
    }

    @Override
    public Account find(Account.UserId userId) {
        AccountDO accountDO = accountDAO.selectByUserId(userId.getId());
        return accountBuilder.toAccount(accountDO);
    }

    @Override
    public Account save(Account account) {
        AccountDO accountDO = accountBuilder.fromAccount(account);
        if (accountDO.getId() == null) {
            accountDAO.insert(accountDO);
        } else {
            accountDAO.update(accountDO);
        }
        return accountBuilder.toAccount(accountDO);
    }
}