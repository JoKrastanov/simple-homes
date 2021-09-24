package com.example.Simple_Homes.intefaces.AccountInterfaces;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.managers.AccountManager;

import java.util.List;

public interface IAccountManager {
    public List<Account> getAccounts();
    Account getAccount(int id);
    public boolean removeAccount(int id);
    public boolean addAccount(Account account);
    public boolean updateAccount(Account account);
}
