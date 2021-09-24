package com.example.Simple_Homes.repository;

import com.example.Simple_Homes.classes.Account;

import com.example.Simple_Homes.intefaces.AccountInterfaces.IAccountDatabase;

import java.util.ArrayList;
import java.util.List;

public class TestDataAccounts implements IAccountDatabase {

    private final List<Account> accountList = new ArrayList<>();

    public TestDataAccounts() {
        accountList.add(new Account("Joan Krastanov", "joankrastanov@gmail.com", "+31874052359", "password"));
        accountList.add(new Account("Test User 1", "tu1@gmail.com", "+31874052359", "password"));
        accountList.add(new Account("Test User 2", "tu2@gmail.com", "+31874052359" , "password"));
        accountList.add(new Account("Test User 3", "tu3@gmail.com", "+31874052359", "password"));
        accountList.add(new Account("Test User 4", "tu4@gmail.com", "+31874052359", "password"));
    }

    @Override
    public List<Account> loadAllAccounts() {
        return accountList;
    }

    @Override
    public Account loadAccount(int id) {
        for (Account account : accountList) {
            if (account.getId() == id)
                return account;
        }
        return null;
    }

    @Override
    public boolean deleteAccount(int id) {
        Account acc = loadAccount(id);
        if (acc == null){
            return false;
        }
        accountList.remove(acc);
        return true;
    }

    @Override
    public boolean createAccount(Account acc) {
            if(!accountList.contains(acc)) {
                accountList.add(acc);
                return true;
            }
        return false;
    }

    @Override
    public boolean upadteAccount(Account acc) {
            for (Account account : accountList) {
                if (account.getId() == acc.getId()) {
                    account.setName(acc.getName());
                    account.setEmail(acc.getEmail());
                    account.setPhoneNumber(acc.getPhoneNumber());
                    return true;
                }
            }
        return false;
    }
}
