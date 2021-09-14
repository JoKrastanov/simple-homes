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

}
