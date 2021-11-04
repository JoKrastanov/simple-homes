package com.example.Simple_Homes.services;

import com.example.Simple_Homes.classes.Account;

import java.util.List;

public interface IAccountService {
    public List<Account> getAccounts();
    Account getAccount(int id);
    public boolean removeAccount(int id);
    public boolean addAccount(Account account);
    public boolean updateAccount(Account account);
    public Account logInAccount(String email, String password);
}
