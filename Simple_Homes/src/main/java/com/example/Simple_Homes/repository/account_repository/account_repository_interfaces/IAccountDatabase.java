package com.example.simple_homes.repository.account_repository.account_repository_interfaces;

import com.example.simple_homes.classes.Account;

import java.util.List;

public interface IAccountDatabase {
    List<Account> loadAllAccounts();
    Account loadAccount(Long id);
    void deleteAccount(Long id);
    void createAccount(Account acc);
    boolean updateAccount(Account acc);
    Account findByEmail(String email);
}
