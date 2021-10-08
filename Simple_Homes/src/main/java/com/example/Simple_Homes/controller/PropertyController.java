package com.example.Simple_Homes.controller;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")

public class PropertyController {
    private IPropertyService PROPERTY_MANAGER;

    public PropertyController(IPropertyService propertyManager) {PROPERTY_MANAGER = propertyManager;}

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("{id}")
    public ResponseEntity<Property> getPropertyPath(@PathVariable(value = "id") int id)
    {
        Property property = (Property)PROPERTY_MANAGER.getProperty(id);

        if(property != null)
        {return ResponseEntity.ok().body(property);}
        else {return ResponseEntity.notFound().build();}
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties(@RequestParam(required = false, value = "location") String location, @RequestParam(required = false, value = "type") String type ) {

        List<Property> properties = new ArrayList<>();

        if (location != " " && type != " ") {
            properties.addAll(PROPERTY_MANAGER.getPropertiesTypeAndAddress(type, location));
        }
        else if (location != null) {
            properties.addAll(PROPERTY_MANAGER.getPropertiesAddress(location));
        }
        else if (type !=  null) {
            properties.addAll(PROPERTY_MANAGER.getPropertiesType(type));
        }
        else {
            properties.addAll(PROPERTY_MANAGER.getProperties());
        }

        if (properties != null) {return ResponseEntity.ok().body(properties);}
        else {return ResponseEntity.notFound().build();}
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("{id}")
    public ResponseEntity deleteProperty(@PathVariable int id) {
        PROPERTY_MANAGER.removeProperty(id);
        return  ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property)
    {
        if(!PROPERTY_MANAGER.addProperty(property))
        {
            String answer = "Property with ID " + property.getId() + " already exists!";
            return new ResponseEntity(answer, HttpStatus.CONFLICT);
        }
        else {
            String url = "properties/" + property.getId();
            URI uri =URI.create(url);
            return new ResponseEntity(uri, HttpStatus.CREATED);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping()
    public ResponseEntity<Property> updateProperty(@RequestBody Property property)
    {
        if(PROPERTY_MANAGER.updateProperty(property)) {
            return ResponseEntity.noContent().build();
        }
        else {return new ResponseEntity("Please provide a valid id.", HttpStatus.NOT_FOUND);}
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable("id") int id, @RequestParam("type") String type, @RequestParam("price") double price, @RequestParam("address") String address, @RequestParam("postalCode") String postalCode, @RequestParam("city") String city, @RequestParam("size") int size, @RequestParam("DateAvailable") Date dateAvailable, @RequestParam("Availability") boolean available, @RequestParam("description") String description, @RequestParam("publisher")Account publisher, @RequestParam("forSale") boolean forSale, @RequestParam("rooms") int rooms, @RequestParam("interior") String interior)
    {
        Property property = (Property)PROPERTY_MANAGER.getProperty(id);
        if (property == null)
        {return new ResponseEntity("Property ID is invalid", HttpStatus.NOT_FOUND);}
        else {
            property.setAddress(address);
            property.setAvailability(available);
            property.setCity(city);
            property.setPrice(price);
            property.setSize(size);
            property.setDateAvailable(dateAvailable);
            property.setType(type);
            property.setDescription(description);
            property.setPublisher(publisher);
            property.setForSale(forSale);
            property.setPostalCode(postalCode);
            property.setInterior(interior);
            property.setRooms(rooms);

            return ResponseEntity.noContent().build();
        }
    }
    
//    @CrossOrigin("http://localhost:3000")
//    @GetMapping
//    public ResponseEntity<List<Property>> getPropertiesType(@RequestParam("type") String type) {
//        List<Property> properties = PROPERTY_MANAGER.getPropertiesType(type);
//        if (properties != null)
//        {return ResponseEntity.ok().body(properties);}
//        else {return ResponseEntity.notFound().build();}
//    }
//
//    @CrossOrigin("http://localhost:3000")
//    @GetMapping
//    public ResponseEntity<List<Property>> getPropertiesAddress(@RequestParam("address") String address) {
//        List<Property> properties = PROPERTY_MANAGER.getPropertiesAddress(address);
//        if (properties != null)
//        {return ResponseEntity.ok().body(properties);}
//        else {return ResponseEntity.notFound().build();}
//    }
}
