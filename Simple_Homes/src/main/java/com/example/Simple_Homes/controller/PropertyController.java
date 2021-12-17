package com.example.Simple_Homes.controller;

import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.classes.Viewing;
import com.example.Simple_Homes.managers.PropertyService.PropertyServiceInterfaces.IPropertyService;
import com.example.Simple_Homes.managers.ViewingService.ViewingServiceInterfaces.IViewingService;
import com.example.Simple_Homes.requests.FilterAccountRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private IPropertyService PROPERTY_MANAGER;
    @Autowired
    private IViewingService VIEWING_MANAGER;


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("{id}")
    public ResponseEntity<Property> getPropertyPath(@PathVariable(value = "id") Long id)
    {
        Property property = PROPERTY_MANAGER.getProperty(id);

        if(property != null)
        {return ResponseEntity.ok().body(property);}
        else {return ResponseEntity.notFound().build();}
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = PROPERTY_MANAGER.getProperties();
        if (properties != null) {return ResponseEntity.ok().body(properties);}
        else {return ResponseEntity.notFound().build();}
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("{id}")
    public ResponseEntity deleteProperty(@PathVariable Long id) {
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

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/filter")
    public ResponseEntity<List<Property>> getPropertiesType(@RequestBody FilterAccountRequest request) {
        List<Property> properties = PROPERTY_MANAGER.filterProperties(request);
        if (properties != null)
        {return ResponseEntity.ok().body(properties);}
        else {return ResponseEntity.notFound().build();}
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/search/{location}")
    public ResponseEntity<List<Property>> searchPropertiesByLocation(@PathVariable String location) {
        List<Property> properties = PROPERTY_MANAGER.searchPropertiesByLocation(location);
        if (properties != null)
        {return ResponseEntity.ok().body(properties);}
        else {return ResponseEntity.notFound().build();}
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping("/viewing")
    public ResponseEntity<Viewing> createViewing(@RequestBody Viewing viewing)
    {
        if(VIEWING_MANAGER.createViewing(viewing))
        {return ResponseEntity.ok().body(viewing);}
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin("http://localhost:3000")
    @DeleteMapping("/viewing/{id}")
    public ResponseEntity<Viewing> deleteViewing(@PathVariable Long id)
    {
        VIEWING_MANAGER.deleteViewing(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/viewing/account/{id}")
    public ResponseEntity<List<Viewing>> getAccountViewings(@PathVariable Long id)
    {
        List<Viewing> accountViewings = VIEWING_MANAGER.getAccountViewings(id);
        if (accountViewings != null) {
            return ResponseEntity.ok().body(accountViewings);
        }
        else{return ResponseEntity.notFound().build();}
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/viewing/property/{id}")
    public ResponseEntity<List<Viewing>> getPropertyViewings(@PathVariable Long id)
    {
        List<Viewing> propertyViewings = VIEWING_MANAGER.getPropertyViewings(id);
        if (propertyViewings != null) {
            return ResponseEntity.ok().body(propertyViewings);
        }
        else{return ResponseEntity.notFound().build();}
    }
}
