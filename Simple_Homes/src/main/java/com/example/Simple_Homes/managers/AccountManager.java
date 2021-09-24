package com.example.Simple_Homes.managers;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.intefaces.AccountInterfaces.IAccountManager;
import com.example.Simple_Homes.repository.TestDataAccounts;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountManager implements IAccountManager {

    TestDataAccounts TEST_DATA_ACCOUNTS = new TestDataAccounts();

    @Override
    public List<Account> getAccounts() {return (List<Account>) TEST_DATA_ACCOUNTS.loadAllAccounts();}

    @Override
    public Account getAccount(int id) {return  (Account) TEST_DATA_ACCOUNTS.loadAccount(id);}

    @Override
    public boolean removeAccount(int id) {return TEST_DATA_ACCOUNTS.deleteAccount(id);}

    @Override
    public boolean addAccount(Account account) {return TEST_DATA_ACCOUNTS.createAccount(account);}

    @Override
    public boolean updateAccount(Account account) {return TEST_DATA_ACCOUNTS.upadteAccount(account);}
}
