package com.example.Simple_Homes.controller;

import com.example.Simple_Homes.classes.*;
import  com .example.Simple_Homes.repository.*;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")

public class PropertyController {
    public static final TestData testData = new TestData();

    @GetMapping("/hello")
    @ResponseBody
    public String Hello()
    {
        String msg = "Welcome to the application";
        return msg;
    }

    @GetMapping("{id}")
    public ResponseEntity<Property> getPropertyPath(@PathVariable(value = "id") int id)
    {
        Property property = testData.getProperty(id);

        if(property != null)
        {return ResponseEntity.ok().body(property);}
        else {return ResponseEntity.notFound().build();}
    }

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = testData.getProperties();
        if (properties != null)
        {return ResponseEntity.ok().body(properties);}
        else {return ResponseEntity.notFound().build();}
    }

    @DeleteMapping
    public ResponseEntity deleteProperty(@PathVariable int id) {
        testData.removeProperty(id);
        return  ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property)
    {
        if(!testData.addProperty(property))
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

    @PutMapping()
    public ResponseEntity<Property> updateProperty(@RequestBody Property property)
    {
        if(testData.updateProperty(property)) {
            return ResponseEntity.noContent().build();
        }
        else {return new ResponseEntity("Please provide a valid id.", HttpStatus.NOT_FOUND);}
    }

    @PutMapping("{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable("id") int id, @RequestParam("type") String type, @RequestParam("price") double price, @RequestParam("address") String address, @RequestParam("postalCode") String postalCode, @RequestParam("city") String city, @RequestParam("size") int size, @RequestParam("DateAvailable") Date dateAvailable, @RequestParam("Availability") boolean available)
    {
        Property property = testData.getProperty(id);
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
