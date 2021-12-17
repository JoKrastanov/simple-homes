package com.example.Simple_Homes.managers.AccountService;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.managers.AccountService.AccountServiceInterfaces.IAccountService;
import com.example.Simple_Homes.repository.AccountRepository.AccountRepositoryInterfaces.IAccountDatabase;
import com.example.Simple_Homes.requests.AccountCreateRequest;
import com.example.Simple_Homes.requests.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final IAccountDatabase ACCOUNT_DATABASE;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public List<AccountDTO> getAccounts() {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for(Account acc : ACCOUNT_DATABASE.loadAllAccounts()) {
            accountDTOS.add(new AccountDTO(acc.getId(),acc.getName(), acc.getEmail(), acc.getPhoneNumber()));
        }
        return accountDTOS;
    }

    @Override
    public AccountDTO getAccount(Long id) {
        Account acc = ACCOUNT_DATABASE.loadAccount(id);
        AccountDTO dto = new AccountDTO(acc.getId(),acc.getName(), acc.getEmail(), acc.getPhoneNumber());
        return dto;
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
    public AccountDTO logInAccount(String email, String password) {
        List<Account> accounts = getAccountsForLogIn();
        for (Account account : accounts) {
            if (account.getEmail().equals(email) && passwordEncoder.matches(password, account.getPassword())) {
                AccountDTO dto = new AccountDTO(account.getId(),account.getName(), account.getEmail(), account.getPhoneNumber());
                return dto;
            }
        }
        return null;
    }
    private List<Account> getAccountsForLogIn() {return ACCOUNT_DATABASE.loadAllAccounts();}
}
