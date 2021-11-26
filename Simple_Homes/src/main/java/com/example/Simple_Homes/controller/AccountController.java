package com.example.Simple_Homes.controller;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.managers.AccountService.AccountServiceInterfaces.IAccountService;
import com.example.Simple_Homes.requests.AccountCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final IAccountService ACCOUNT_MANAGER;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("{id}")
    public ResponseEntity<Account> getAccountPath(@PathVariable(value = "id") Long id) {
        Account account = ACCOUNT_MANAGER.getAccount(id);

        if (account != null) {
            return ResponseEntity.ok().body(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = ACCOUNT_MANAGER.getAccounts();
        if (accounts != null) {
            return ResponseEntity.ok().body(accounts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id) {
        ACCOUNT_MANAGER.removeAccount(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountCreateRequest request) {

        ACCOUNT_MANAGER.addAccount(request);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping()
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        if (ACCOUNT_MANAGER.updateAccount(account)) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity("Please provide a valid id.", HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("password") String password) {
        Account account = ACCOUNT_MANAGER.getAccount(id);
        if (account == null) {
            return new ResponseEntity("Account ID is invalid", HttpStatus.NOT_FOUND);
        } else {
            account.setName(name);
            account.setEmail(email);
            account.setPhoneNumber(phoneNumber);
            account.setPassword(password);

            return ResponseEntity.noContent().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/login")
    public ResponseEntity<Account> getLoggedInAccount(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password)
    {
        Account account = ACCOUNT_MANAGER.logInAccount(email, password);

        if (account != null) {
            return ResponseEntity.ok().body(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
