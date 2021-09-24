package com.example.Simple_Homes.intefaces;

import com.example.Simple_Homes.classes.Account;

import java.util.List;

public interface IAccountDatabase {
    public List<Account> loadAllAccounts();
    public Account loadAccount(int id);
    public boolean deleteAccount(int id);
    public boolean createAccount(Account acc);
    public boolean upadteAccount(Account acc);
}
