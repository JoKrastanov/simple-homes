package com.example.Simple_Homes.classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Property {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static final AtomicInteger count = new AtomicInteger(0);

    private int id;
    private String type;
    private double price;
    private boolean taken;
    private String description;
    private boolean forSale;
    private Account publisher;
    private String address;
    private String postalCode;
    private String city;
    private int size;
    private Date dateAvailable;
    private Date datePublished;
    private int rooms;
    private String interior;
    private List<Viewing> viewings;

    public Property(String type, double price, Account a, String address, String postalCode, String city, int size, Date dateAvailable, String description, boolean forSale, int rooms, String interior)
    {
        id = count.incrementAndGet();
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
        this.description = description;
        this.forSale = forSale;
        this.rooms = rooms;
        this.interior = interior;
        viewings = new ArrayList<>();
    }

    // Get and Set Properties
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

    public String getDescription() {return  description;}
    public void setDescription(String description) {this.description = description;}

    public boolean getForSale() {return forSale;}
    public void setForSale(boolean forSale) {this.forSale = forSale;}

    public String getPostalCode() {return postalCode;}
    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

    public Account getPublisher() {return publisher;}
    public void setPublisher(Account publisher) {this.publisher = publisher;}

    public List<Viewing> getViewings() {return viewings;}
    public void setViewings(List<Viewing> viewings) {this.viewings = viewings;}

    public int getRooms() {return rooms;}
    public void setRooms(int rooms) {this.rooms = rooms;}

    public String getInterior() {return interior;}
    public void setInterior(String interior) {this.interior = interior;}

    // Methods
    public void addViewing(Viewing viewing) {viewings.add(viewing);}
}

