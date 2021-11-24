package com.example.Simple_Homes.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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


    public void setAvailability(boolean available) {
        this.taken = available;
    }

    public boolean getAvailability() {
        return taken;
    }

    public Long getPublisher() {
        return publisherId;
    }

    public void setPublisher(Long publisher) {
        publisherId = publisher;
    }
}

