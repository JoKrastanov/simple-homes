package com.example.Simple_Homes.managers.AccountService;

import com.example.Simple_Homes.managers.AccountService.AccountServiceInterfaces.IAccountService;
import com.example.Simple_Homes.requests.AccountCreateRequest;
import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.repository.AccountRepository.AccountRepositoryInterfaces.IAccountDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final IAccountDatabase ACCOUNT_DATABASE;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public List<Account> getAccounts() {
        return ACCOUNT_DATABASE.loadAllAccounts();
    }

    @Override
    public Account getAccount(Long id) {
        return ACCOUNT_DATABASE.loadAccount(id);
    }

    @Override
    public void removeAccount(Long id) {
        ACCOUNT_DATABASE.deleteAccount(id);
    }

    @Override
    public void addAccount(AccountCreateRequest request) {
        Account user = new Account();

        Optional<Account> byEmail = Optional.ofNullable(ACCOUNT_DATABASE.findByEmail(request.getUsername()));
        if (byEmail.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        user.setEmail(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setName(request.getName());
        ACCOUNT_DATABASE.createAccount(user);
    }

    @Override
    public boolean updateAccount(Account account) {
        String password = passwordEncoder.encode(account.getPassword());
        account.setPassword(password);
        return ACCOUNT_DATABASE.updateAccount(account);
    }

    @Override
    public Account findByEmail(String email) {
        return ACCOUNT_DATABASE.findByEmail(email);
    }

    @Override
    public Account logInAccount(String email, String password) {
        List<Account> accounts = getAccounts();
        for (Account account : accounts) {
            if (account.getEmail().equals(email) && passwordEncoder.matches(password, account.getPassword())) {
                return account;
            }
        }
        return null;
    }
}
