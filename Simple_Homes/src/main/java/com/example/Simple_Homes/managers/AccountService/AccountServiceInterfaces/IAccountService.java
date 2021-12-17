package com.example.Simple_Homes.managers.AccountService.AccountServiceInterfaces;

import com.example.Simple_Homes.requests.AccountCreateRequest;
import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.requests.AccountDTO;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> getAccounts();
    AccountDTO getAccount(Long id);
    void removeAccount(Long id);
    void addAccount(AccountCreateRequest account);
    boolean updateAccount(Account account);
    Account findByEmail(String email);
    AccountDTO logInAccount(String email, String password);
}
