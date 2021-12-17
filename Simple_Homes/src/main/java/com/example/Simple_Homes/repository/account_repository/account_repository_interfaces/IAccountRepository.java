package com.example.simple_homes.repository.account_repository.account_repository_interfaces;

import com.example.simple_homes.classes.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);

}
