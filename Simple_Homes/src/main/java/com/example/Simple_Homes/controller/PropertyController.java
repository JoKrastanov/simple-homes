package com.example.Simple_Homes.controller;

import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyDatabase;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyManager;
import  com .example.Simple_Homes.repository.TestDataProperties;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/properties")

public class PropertyController {
    private IPropertyManager CONTROLLER_MANAGER;

    public PropertyController(IPropertyManager propertyManager) {CONTROLLER_MANAGER = propertyManager;}

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("{id}")
    public ResponseEntity<Property> getPropertyPath(@PathVariable(value = "id") int id)
    {
        Property property = (Property)CONTROLLER_MANAGER.getProperty(id);

        if(property != null)
        {return ResponseEntity.ok().body(property);}
        else {return ResponseEntity.notFound().build();}
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = (List<Property>) CONTROLLER_MANAGER.getProperties();
        if (properties != null)
        {return ResponseEntity.ok().body(properties);}
        else {return ResponseEntity.notFound().build();}
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("{id}")
    public ResponseEntity deleteProperty(@PathVariable int id) {
        CONTROLLER_MANAGER.removeProperty(id);
        return  ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property)
    {
        if(!CONTROLLER_MANAGER.addProperty(property))
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
        if(CONTROLLER_MANAGER.updateProperty(property)) {
            return ResponseEntity.noContent().build();
        }
        else {return new ResponseEntity("Please provide a valid id.", HttpStatus.NOT_FOUND);}
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable("id") int id, @RequestParam("type") String type, @RequestParam("price") double price, @RequestParam("address") String address, @RequestParam("postalCode") String postalCode, @RequestParam("city") String city, @RequestParam("size") int size, @RequestParam("DateAvailable") Date dateAvailable, @RequestParam("Availability") boolean available)
    {
        Property property = (Property)CONTROLLER_MANAGER.getProperty(id);
        if (property == null)
        {return new ResponseEntity("Property ID is invalid", HttpStatus.NOT_FOUND);}
        else {
            property.setType(type);
            property.setDateAvailable(dateAvailable);
            property.setSize(size);
            property.setPrice(price);
            property.setCity(city);
            property.setAvailability(available);
            property.setAddress(address);
            return ResponseEntity.noContent().build();
        }
    }

}
