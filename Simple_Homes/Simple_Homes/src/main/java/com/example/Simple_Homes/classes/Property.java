package com.example.Simple_Homes.classes;

import java.lang.reflect.Type;
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

    public Property(int id, String type, double price, Account a, String address, String postalCode, String city, int size, Date dateAvailable)
    {
        datePublished = new Date(System.currentTimeMillis());
        taken = false;

        this.id = id;
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
    public int getId() {return id;}

    public String getType() {return type;}
    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {return price;}
    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {return address;}
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {return city;}
    public void setCity(String city) {
        this.city = city;
    }

    public int getSize() {return size;}
    public void setSize(int size) {
        this.size = size;
    }

    public Date getDateAvailable() {return dateAvailable;}
    public void setDateAvailable(Date dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public boolean getAvailability() {
        return taken;
    }
    public void setAvailability(boolean taken) {
        this.taken = taken;
    }

    public String getDate() {
        return formatter.format(datePublished);
    }

}

