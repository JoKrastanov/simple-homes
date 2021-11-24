package com.example.Simple_Homes.repository.AccountRepository;

import com.example.Simple_Homes.classes.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);

}
