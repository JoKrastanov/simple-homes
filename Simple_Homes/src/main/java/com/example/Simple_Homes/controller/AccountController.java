package com.example.Simple_Homes.controller;

import com.example.Simple_Homes.LogInForm;
import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.intefaces.AccountInterfaces.IAccountService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private IAccountService ACCOUNT_MANAGER;

    public AccountController(IAccountService accountManager)
    {
        ACCOUNT_MANAGER = accountManager;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("{id}")
    public ResponseEntity<Account> getAccountPath(@PathVariable(value = "id") int id)
    {
        Account account = (Account)ACCOUNT_MANAGER.getAccount(id);

        if (account != null)
        {return ResponseEntity.ok().body(account);}
        else {return ResponseEntity.notFound().build();}
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = (List<Account>) ACCOUNT_MANAGER.getAccounts();
        if (accounts != null)
        {return ResponseEntity.ok().body(accounts);}
        else {return ResponseEntity.notFound().build();}
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("{id}")
    public ResponseEntity deleteAccount(@PathVariable int id) {
        ACCOUNT_MANAGER.removeAccount(id);
        return  ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account)
    {
    if(!ACCOUNT_MANAGER.addAccount(account))
    {
        String answer = "Account with ID " + account.getId() + " already exists!";
        return new ResponseEntity(answer, HttpStatus.CONFLICT);
    }
    else {
        String url = "accounts/" + account.getId();
        URI uri =URI.create(url);
        return new ResponseEntity(uri, HttpStatus.CREATED);
    }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping()
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        if (ACCOUNT_MANAGER.updateAccount(account)) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity("Please provide a valid id.",HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("password") String password){
        Account account = (Account) ACCOUNT_MANAGER.getAccount(id);
        if (account == null)
        {
            return new ResponseEntity("Account ID is invalid", HttpStatus.NOT_FOUND);
        }
        else
        {
            account.setName(name);
            account.setEmail(email);
            account.setPhoneNumber(phoneNumber);
            account.setPassword(password);

            return ResponseEntity.noContent().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping(path = "/login")
    public ResponseEntity<Account> logIn(@RequestBody LogInForm logInForm) {
        Account acc = ACCOUNT_MANAGER.logInAccount(logInForm.getEmail(), logInForm.getPassword());

        if (acc != null) {return ResponseEntity.ok().body(acc);}
        return  ResponseEntity.notFound().build();
    }
}
