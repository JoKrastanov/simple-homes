package com.example.Simple_Homes.intefaces.AccountInterfaces;

import com.example.Simple_Homes.classes.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAccounts();
    Account getAccount(Long id);
    void removeAccount(Long id);
    void addAccount(Account account);
    boolean updateAccount(Account account);
    Account logInAccount(String email, String password);
}
