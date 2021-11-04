package com.example.Simple_Homes;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.controller.AccountController;
import com.example.Simple_Homes.intefaces.AccountInterfaces.IAccountService;
import com.example.Simple_Homes.managers.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.internal.matchers.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private String DEFAULT_NAME = "John Smith";
    private String DEFAULT_EMAIL = "johnsmith@gmail.com";
    private String DEFAULT_PHONE = "+31012345678";
    private String DEFAULT_PASSWORD = "password";
    private Account Test_Account = new Account(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE, DEFAULT_PASSWORD);

    @Test
    public void AccountCreationSuccessfulTest()
    {
        Account account = new Account(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE, DEFAULT_PASSWORD);


        assertEquals(DEFAULT_NAME, account.getName());
        assertEquals(DEFAULT_EMAIL, account.getEmail());
        assertEquals(DEFAULT_PHONE, account.getPhoneNumber());
    }

    @Test
    public void SetNameTestSuccessful()
    {
        String newName = "Nickolas Johnson";
        Test_Account.setName(newName);

        assertEquals(Test_Account.getName(), newName);
    }
    @Test
    public void SetNameTestUnsuccessful()
    {
        String newName = "Nickolas Johnson";
        Test_Account.setName(newName);

        Assertions.assertNotEquals(Test_Account.getName(), DEFAULT_NAME);
    }

    @Test
    public void SetPasswordTestSuccessful()
    {
        String newPassword = "password1";
        Test_Account.setPassword(newPassword);

        assertEquals(Test_Account.getPassword(), newPassword);
    }
    @Test
    public void SetPasswordTestUnsuccessful()
    {
        String newPassword = "password1";
        Test_Account.setPassword(newPassword);

        Assertions.assertNotEquals(Test_Account.getPassword(), DEFAULT_PASSWORD);
    }

    @Test
    public void SetEmailTestSuccessful()
    {
        String newEmail = "mail@mail.com";
        Test_Account.setEmail(newEmail);

        assertEquals(Test_Account.getEmail(), newEmail);
    }
    @Test
    public void SetEmailTestUnsuccessful()
    {
        String newEmail = "mail@mail.com";
        Test_Account.setEmail(newEmail);

        Assertions.assertNotEquals(Test_Account.getEmail(), DEFAULT_EMAIL);
    }

}
