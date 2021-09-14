package com.example.Simple_Homes.repository;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.classes.Viewing;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    private final List<Account> accountList = new ArrayList<>();

    public TestData() {
        accountList.add(new Account(1, "Joan Krastanov", "joankrastanov@gmail.com", "+31874052359"));
        accountList.add(new Account(2, "Test User 1", "tu1@gmail.com", "+31874052359"));
        accountList.add(new Account(3, "Test User 2", "tu2@gmail.com", "+31874052359"));
        accountList.add(new Account(4, "Test User 3", "tu3@gmail.com", "+31874052359"));
        accountList.add(new Account(5, "Test User 4", "tu4@gmail.com", "+31874052359"));
    }

    public List<Account> getAccounts()
    {return accountList;}

    public Account getAccount(int id) {
        for (Account account : accountList) {
            if (account.getId() == id)
                return account;
        }
        return null;
    }

    public boolean removeStudent(int id)
    {
        Account account = getAccount(id);
        if (account == null){
            return false;
        }
        accountList.remove(account);
        return true;
    }
    public boolean add(Account account) {
        if (this.getAccount(account.getId()) != null){
            return false;
        }
        accountList.add(account);
        return true;
    }
    public boolean update(Account account) {
        Account old = this.getAccount(account.getId());
        if (old == null) {
            return false;
        }
        old.setName(account.getName());
        return true;
    }

}
