package com.example.Simple_Homes.controller;

import com.example.Simple_Homes.classes.*;
import  com .example.Simple_Homes.repository.*;

import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final  TestData testData = new TestData();

    @GetMapping("/hello")

    @ResponseBody
    public String Hello()
    {
        String msg = "Welcome to the application!";
        return msg;
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> getAccountPath(@PathVariable(value = "id") int id)
    {
        Account account = testData.getAccount(id);

        if (account != null)
        {return ResponseEntity.ok().body(account);}
        else {return ResponseEntity.notFound().build();}
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = testData.getAccounts();
        if (accounts != null)
        {return ResponseEntity.ok().body(accounts);}
        else {return ResponseEntity.notFound().build();}
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteAccount(@PathVariable int id) {
        testData.removeAccount(id);
        return  ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Account> createAccoun(@RequestBody Account account)
    {
    if(!testData.addAccount(account))
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

    @PutMapping()
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        if (testData.updateAccount(account)) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity("Please provide a valid id.",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber){
        Account account = testData.getAccount(id);
        if (account == null)
        {
            return new ResponseEntity("Account ID is invalid", HttpStatus.NOT_FOUND);
        }
        else
        {
            account.setName(name);
            account.setEmail(email);
            account.setPhoneNumber(phoneNumber);
            return ResponseEntity.noContent().build();
        }
    }
}
