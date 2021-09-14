package com.example.Simple_Homes.classes;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private ArrayList<Property> propertyList;

    public Account(int id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        propertyList = new ArrayList<>();
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


}

