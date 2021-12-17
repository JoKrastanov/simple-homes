package com.example.simple_homes.managers.account_service.account_service_interfaces;

import com.example.simple_homes.requests.AccountCreateRequest;
import com.example.simple_homes.classes.Account;
import com.example.simple_homes.requests.AccountDTO;

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
