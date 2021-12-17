package com.example.simple_homes.repository.account_repository;

import com.example.simple_homes.classes.Account;
import com.example.simple_homes.repository.account_repository.account_repository_interfaces.IAccountDatabase;
import com.example.simple_homes.repository.account_repository.account_repository_interfaces.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountJPA implements IAccountDatabase {

    IAccountRepository repo;

    @Override
    public List<Account> loadAllAccounts() {
        return repo.findAll();
    }

    @Override
    public Account loadAccount(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteAccount(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void createAccount(Account acc) {
        repo.save(acc);
    }

    @Override
    public boolean updateAccount(Account acc) {
            for (Account account : loadAllAccounts()) {
                if (account.getId().equals(acc.getId())) {
                    account.setName(acc.getName());
                    account.setEmail(acc.getEmail());
                    account.setPhoneNumber(acc.getPhoneNumber());
                    account.setPassword(acc.getPassword());
                    repo.save(account);
                    return true;
                }
            }
        return false;
    }
    @Override
    public Account findByEmail(String email)
    {return repo.findByEmail(email).orElse(null);}

}
