package com.example.Simple_Homes;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.controller.AccountController;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private int DEFAULT_ID = 20;
    private String DEFAULT_NAME = "John Smith";
    private String DEFAULT_EMAIL = "johnsmith@gmail.com";
    private String DEFAULT_PHONE = "+31012345678";

    @Test
    public void AccountCreationSuccessfulTest()
    {
        Account account = new Account(DEFAULT_ID, DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);

        assertEquals(DEFAULT_ID,account.getId());
        assertEquals(DEFAULT_NAME, account.getName());
        assertEquals(DEFAULT_EMAIL, account.getEmail());
        assertEquals(DEFAULT_PHONE, account.getPhoneNumber());
    }

}
