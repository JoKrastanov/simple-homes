package com.example.simple_homes.UnitTests.ModelTests;

import com.example.simple_homes.classes.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    private String DEFAULT_NAME = "John Smith";
    private String DEFAULT_EMAIL = "johnsmith@gmail.com";
    private String DEFAULT_PHONE = "+31012345678";
    private String DEFAULT_PASSWORD = "password";
    private Account Test_Account = new Account(1L ,DEFAULT_PASSWORD, DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);

    @Test
    void AccountCreationSuccessfulTest()
    {
        Account account = new Account(1L ,DEFAULT_PASSWORD, DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);

        assertEquals(DEFAULT_NAME, account.getName());
        assertEquals(DEFAULT_EMAIL, account.getEmail());
        assertEquals(DEFAULT_PHONE, account.getPhoneNumber());
    }

    @Test
    void SetNameTestSuccessful()
    {
        String newName = "Nickolas Johnson";
        Test_Account.setName(newName);

        assertEquals(Test_Account.getName(), newName);
    }
    @Test
    void SetNameTestUnsuccessful()
    {
        String newName = "Nickolas Johnson";
        Test_Account.setName(newName);

        Assertions.assertNotEquals(Test_Account.getName(), DEFAULT_NAME);
    }

    @Test
    void SetPasswordTestSuccessful()
    {
        String newPassword = "password1";
        Test_Account.setPassword(newPassword);

        assertEquals(Test_Account.getPassword(), newPassword);
    }
    @Test
    void SetPasswordTestUnsuccessful()
    {
        String newPassword = "password1";
        Test_Account.setPassword(newPassword);

        Assertions.assertNotEquals(Test_Account.getPassword(), DEFAULT_PASSWORD);
    }

    @Test
    void SetEmailTestSuccessful()
    {
        String newEmail = "mail@mail.com";
        Test_Account.setEmail(newEmail);

        assertEquals(Test_Account.getEmail(), newEmail);
    }
    @Test
    void SetEmailTestUnsuccessful()
    {
        String newEmail = "mail@mail.com";
        Test_Account.setEmail(newEmail);

        Assertions.assertNotEquals(Test_Account.getEmail(), DEFAULT_EMAIL);
    }

}
