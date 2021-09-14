package com.example.Simple_Homes.repository;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.classes.Viewing;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestData {

    private final List<Account> accountList = new ArrayList<>();
    private final List<Property> propertyList = new ArrayList<>();

    public TestData() {
        accountList.add(new Account(1, "Joan Krastanov", "joankrastanov@gmail.com", "+31874052359"));
        accountList.add(new Account(2, "Test User 1", "tu1@gmail.com", "+31874052359"));
        accountList.add(new Account(3, "Test User 2", "tu2@gmail.com", "+31874052359"));
        accountList.add(new Account(4, "Test User 3", "tu3@gmail.com", "+31874052359"));
        accountList.add(new Account(5, "Test User 4", "tu4@gmail.com", "+31874052359"));

        Date testDate = new Date(2021, Calendar.JULY, 19);
        propertyList.add(new Property(1, "Room",400, new Account(5, "Test User 4", "tu4@gmail.com", "+31874052359"), "Heezerweg 186", "5614HJ", "Eindhoven", 12, testDate));
        propertyList.add(new Property(2, "Room",450, new Account(5, "Test User 4", "tu4@gmail.com", "+31874052359"), "Heezerweg 155", "5614JD", "Eindhoven", 12, testDate));
    }

    public List<Account> getAccounts()
    {return accountList;}

    public Account getAccount(int id) {
        for (Account account : accountList) {
            if (account.getId() == id)
                return account;
        }
        return null;
    }

    public boolean removeAccount(int id)
    {
        Account account = getAccount(id);
        if (account == null){
            return false;
        }
        accountList.remove(account);
        return true;
    }
    public boolean addAccount(Account account) {
        if (this.getAccount(account.getId()) != null){
            return false;
        }
        accountList.add(account);
        return true;
    }
    public boolean updateAccount(Account account) {
        Account old = this.getAccount(account.getId());
        if (old == null) {
            return false;
        }
        old.setName(account.getName());
        return true;
    }


    public List<Property> getProperties()
    {return propertyList;}

    public Property getProperty(int id) {
        for (Property property : propertyList) {
            if (property.getId() == id)
                return property;
        }
        return null;
    }

    public boolean removeProperty(int id)
    {
        Property property = getProperty(id);
        if (property == null){
            return false;
        }
        propertyList.remove(property);
        return true;
    }
    public boolean addProperty(Property property) {
        if (this.getProperty(property.getId()) != null){
            return false;
        }
        propertyList.add(property);
        return true;
    }
    public boolean updateProperty(Property property) {
        Property old = this.getProperty(property.getId());
        if (old == null) {
            return false;
        }
        old.setAddress(property.getAddress());
        old.setAvailability(property.getAvailability());
        old.setCity(property.getCity());
        old.setPrice(property.getPrice());
        old.setSize(property.getSize());
        old.setDateAvailable(property.getDateAvailable());
        old.setType(property.getType());
        return true;
    }

}
