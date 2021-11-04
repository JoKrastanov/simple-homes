package com.example.Simple_Homes.classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "account")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    public Account() {

    }


    public Account(String name, String email, String phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    // Get & Set Methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

}

