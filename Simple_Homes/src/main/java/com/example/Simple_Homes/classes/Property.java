package com.example.Simple_Homes.classes;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type")
    private String type;
    @Column(name = "price")
    private Double price;
    @Column(name = "taken")
    private Boolean taken;
    @Column(name = "description")
    private String description;
    @Column(name = "forSale")
    private Boolean forSale;
    @Column(name = "publisher")
    private Long publisherId;
    @Column(name = "address")
    private String address;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "size")
    private Integer size;
    @Column(name = "dateAvailable")
    private String dateAvailable;
    @Column(name = "datePublished")
    private String datePublished;
    @Column(name = "rooms")
    private Integer rooms;
    @Column(name = "interior")
    private String interior;

    public Property()  {}

    public Property(String type, double price, Long a, String address, String postalCode, String city, int size, String dateAvailable, String description, boolean forSale, int rooms, String interior, String datePublished)
    {
        taken = false;

        this.type = type;
        this.price = price;
        this.publisherId = a;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.size = size;
        this.dateAvailable = dateAvailable;
        this.description = description;
        this.forSale = forSale;
        this.rooms = rooms;
        this.interior = interior;
        this.datePublished = datePublished;

    }


    // Get and Set Properties
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getType() {return type;}
    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {return price;}
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

    public Integer getSize() {return size;}
    public void setSize(int size) {
        this.size = size;
    }

    public String getDateAvailable() {return dateAvailable;}
    public void setDateAvailable(String dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public Boolean getAvailability() {
        return taken;
    }
    public void setAvailability(boolean taken) {
        this.taken = taken;
    }

    public String getDescription() {return  description;}
    public void setDescription(String description) {this.description = description;}

    public boolean getForSale() {return forSale;}
    public void setForSale(boolean forSale) {this.forSale = forSale;}

    public String getPostalCode() {return postalCode;}
    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

    public Long getPublisher() {return publisherId;}
    public void setPublisher(Long publisher) {this.publisherId = publisher;}

    public int getRooms() {return rooms;}
    public void setRooms(int rooms) {this.rooms = rooms;}

    public String getInterior() {return interior;}
    public void setInterior(String interior) {this.interior = interior;}

}

