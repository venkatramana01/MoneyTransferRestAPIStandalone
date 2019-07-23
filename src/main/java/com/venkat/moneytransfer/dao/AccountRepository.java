package com.venkat.moneytransfer.dao;


import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.venkat.moneytransfer.error.DuplicateAccountException;
import com.venkat.moneytransfer.model.Account;

public class AccountRepository {

    private static final AccountRepository INSTANCE = new AccountRepository(new ConcurrentHashMap<String, Account>());
    private final Map<String, Account> accounts;

    private AccountRepository(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public static AccountRepository getInstance() {
        return INSTANCE;
    }

    public Account getById(String id) {
        return accounts.get(id);
    }

    public Collection<Account> getAll() {
        return accounts.values();
    }

    public Account addAccount(Account account) {
        Account accountExists = accounts.putIfAbsent(account.getId(), account);
        if (accountExists != null) {
            throw new DuplicateAccountException(accountExists.getId());
        }

        return getById(account.getId());
    }

    public void removeAll() {
        synchronized (accounts) {
            accounts.clear();
        }
    }
}
