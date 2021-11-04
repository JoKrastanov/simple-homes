package com.example.Simple_Homes.managers;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.intefaces.AccountInterfaces.IAccountDatabase;
import com.example.Simple_Homes.intefaces.AccountInterfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    private IAccountDatabase ACCOUNT_DATABASE;

    @Autowired
    public AccountService(IAccountDatabase accountDatabase)
    {ACCOUNT_DATABASE = accountDatabase;}

    @Override
    public List<Account> getAccounts() {return (List<Account>) ACCOUNT_DATABASE.loadAllAccounts();}

    @Override
    public Account getAccount(int id) {return  (Account) ACCOUNT_DATABASE.loadAccount(id);}

    @Override
    public boolean removeAccount(int id) {return ACCOUNT_DATABASE.deleteAccount(id);}

    @Override
    public boolean addAccount(Account account) {return ACCOUNT_DATABASE.createAccount(account);}

    @Override
    public boolean updateAccount(Account account) {return ACCOUNT_DATABASE.updateAccount(account);}

    @Override
    public Account logInAccount(String email, String password) {return  ACCOUNT_DATABASE.logIn(email, password);}
}
