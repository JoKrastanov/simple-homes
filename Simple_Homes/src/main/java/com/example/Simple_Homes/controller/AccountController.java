package com.example.simple_homes.controller;

import com.example.simple_homes.classes.Account;
import com.example.simple_homes.managers.account_service.account_service_interfaces.IAccountService;
import com.example.simple_homes.requests.AccountCreateRequest;
import com.example.simple_homes.requests.AccountDTO;
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

    private final IAccountService accountManager;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("{id}")
    public ResponseEntity<AccountDTO> getAccountPath(@PathVariable(value = "id") Long id) {
        AccountDTO account = accountManager.getAccount(id);

        if (account != null) {
            return ResponseEntity.ok().body(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<AccountDTO> accounts = accountManager.getAccounts();
        if (accounts != null) {
            return ResponseEntity.ok().body(accounts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id) {
        accountManager.removeAccount(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountCreateRequest request) {

        accountManager.addAccount(request);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping()
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody Account account) {
        if (accountManager.updateAccount(account)) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity("Please provide a valid id.", HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/login")
    public ResponseEntity<AccountDTO> getLoggedInAccount(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password)
    {
        AccountDTO account = accountManager.logInAccount(email, password);

        if (account != null) {
            return ResponseEntity.ok().body(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
