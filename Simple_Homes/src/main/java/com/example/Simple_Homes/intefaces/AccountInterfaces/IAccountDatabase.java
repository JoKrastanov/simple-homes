package com.example.Simple_Homes.intefaces.AccountInterfaces;

import com.example.Simple_Homes.classes.Account;

import java.util.List;

public interface IAccountDatabase {
    List<Account> loadAllAccounts();
    Account loadAccount(Long id);
    void deleteAccount(Long id);
    void createAccount(Account acc);
    boolean updateAccount(Account acc);
    Account findByEmail(String email);
}
