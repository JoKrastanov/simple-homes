package com.example.simple_homes.managers.account_service;

import com.example.simple_homes.classes.Account;
import com.example.simple_homes.managers.account_service.account_service_interfaces.IAccountService;
import com.example.simple_homes.repository.account_repository.account_repository_interfaces.IAccountDatabase;
import com.example.simple_homes.requests.AccountCreateRequest;
import com.example.simple_homes.requests.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final IAccountDatabase accountDatabase;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public List<AccountDTO> getAccounts() {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for(Account acc : accountDatabase.loadAllAccounts()) {
            accountDTOS.add(new AccountDTO(acc.getId(),acc.getName(), acc.getEmail(), acc.getPhoneNumber()));
        }
        return accountDTOS;
    }

    @Override
    public AccountDTO getAccount(Long id) {
        Account acc = accountDatabase.loadAccount(id);
        AccountDTO dto = new AccountDTO(acc.getId(),acc.getName(), acc.getEmail(), acc.getPhoneNumber());
        return dto;
    }

    @Override
    public void removeAccount(Long id) {
        accountDatabase.deleteAccount(id);
    }

    @Override
    public void addAccount(AccountCreateRequest request) {
        Account user = new Account();

        Optional<Account> byEmail = Optional.ofNullable(accountDatabase.findByEmail(request.getUsername()));
        if (byEmail.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        user.setEmail(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setName(request.getName());
        accountDatabase.createAccount(user);
    }

    @Override
    public boolean updateAccount(Account account) {
        String password = passwordEncoder.encode(account.getPassword());
        account.setPassword(password);
        return accountDatabase.updateAccount(account);
    }

    @Override
    public Account findByEmail(String email) {
        return accountDatabase.findByEmail(email);
    }

    @Override
    public AccountDTO logInAccount(String email, String password) {
        List<Account> accounts = getAccountsForLogIn();
        for (Account account : accounts) {
            if (account.getEmail().equals(email) && passwordEncoder.matches(password, account.getPassword())) {
                return new AccountDTO(account.getId(),account.getName(), account.getEmail(), account.getPhoneNumber());
            }
        }
        return null;
    }
    private List<Account> getAccountsForLogIn() {return accountDatabase.loadAllAccounts();}
}
