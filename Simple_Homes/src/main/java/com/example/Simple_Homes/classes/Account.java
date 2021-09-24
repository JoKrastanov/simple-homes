package com.example.Simple_Homes.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private ArrayList<Property> propertyList;
    private ArrayList<Property> bookmarkedProperties;

    public Account(String name, String email, String phoneNumber, String password) {
        id = count.incrementAndGet();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        propertyList = new ArrayList<>();
        bookmarkedProperties = new ArrayList<>();
    }

    // Get & Set Methods
    public int getId()
    {return id;}

    public String getName()
    {return name;}
    public void setName(String name)
    {this.name = name;}

    public String getEmail()
    {return email;}
    public void setEmail(String email)
    {this.email = email;}

    public String getPhoneNumber()
    {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber)
    {this.phoneNumber = phoneNumber;}

    public String getPassword()
    {return password;}
    public void setPassword(String password)
    {this.password = password;}

    public List<Property> getUploadedProperties()
    {return propertyList;}

    public List<Property> getBookmarkedProperties()
    {return bookmarkedProperties;}

    //Methods
    public void uploadProperty(Property property)
    {propertyList.add(property);}

    public void bookmarkProperty(Property property)
    {propertyList.add(property);}
}

