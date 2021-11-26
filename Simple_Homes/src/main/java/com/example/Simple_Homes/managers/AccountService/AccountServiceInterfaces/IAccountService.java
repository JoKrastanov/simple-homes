package com.example.Simple_Homes.managers.AccountService.AccountServiceInterfaces;

import com.example.Simple_Homes.requests.AccountCreateRequest;
import com.example.Simple_Homes.classes.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAccounts();
    Account getAccount(Long id);
    void removeAccount(Long id);
    void addAccount(AccountCreateRequest account);
    boolean updateAccount(Account account);
    Account findByEmail(String email);
    Account logInAccount(String email, String password);
}
