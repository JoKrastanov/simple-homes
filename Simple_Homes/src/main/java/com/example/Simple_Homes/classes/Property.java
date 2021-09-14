package com.example.Simple_Homes.classes;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Property {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private int id;
    private String type;
    private double price;
    private boolean taken;
    private Account publisher;
    private String address;
    private String postalCode;
    private String city;
    private int size;
    private Date dateAvailable;
    private Date datePublished;

    public Property(String type, double price, Account a, String address, String postalCode, String city, int size, Date dateAvailable)
    {
        datePublished = new Date(System.currentTimeMillis());
        taken = false;

        this.type = type;
        this.price = price;
        this.publisher = a;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.size = size;
        this.dateAvailable = dateAvailable;
    }

    // Get Properties
    public String getDate() {
        return formatter.format(datePublished);
    }

}

