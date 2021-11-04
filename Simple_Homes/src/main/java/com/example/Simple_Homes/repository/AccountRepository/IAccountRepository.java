package com.example.Simple_Homes.repository.AccountRepository;

import com.example.Simple_Homes.classes.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {

}
