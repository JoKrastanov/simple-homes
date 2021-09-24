package com.example.Simple_Homes;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.controller.AccountController;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private String DEFAULT_NAME = "John Smith";
    private String DEFAULT_EMAIL = "johnsmith@gmail.com";
    private String DEFAULT_PHONE = "+31012345678";
    private String DEFAULT_PASSWORD = "password";

    @Test
    public void AccountCreationSuccessfulTest()
    {
        Account account = new Account(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE, DEFAULT_PASSWORD);


        assertEquals(DEFAULT_NAME, account.getName());
        assertEquals(DEFAULT_EMAIL, account.getEmail());
        assertEquals(DEFAULT_PHONE, account.getPhoneNumber());
    }

}
