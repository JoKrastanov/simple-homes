package com.example.Simple_Homes.repository.PropertyRepository;

import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyDatabase;
import com.example.Simple_Homes.repository.PropertyRepository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PropertyJPA implements IPropertyDatabase {


    @Autowired
    IPropertyRepository repo;

    @Override
    public List<Property> loadAllProperties() {
        return repo.findAll();
    }

    @Override
    public Property loadProperty(Long id) {
            return repo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteProperty(Long id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public boolean createProperty(Property property) {
        repo.save(property);
        return true;
    }

    @Override
    public boolean updateProperty(Property newProperty) {
            for (Property property : loadAllProperties()) {
                if (property.getId() == newProperty.getId()) {
                    property.setAddress(newProperty.getAddress());
                    property.setAvailability(newProperty.getAvailability());
                    property.setCity(newProperty.getCity());
                    property.setPrice(newProperty.getPrice());
                    property.setSize(newProperty.getSize());
                    property.setDateAvailable(newProperty.getDateAvailable());
                    property.setType(newProperty.getType());
                    property.setDescription(newProperty.getDescription());
                    property.setPublisher(newProperty.getPublisher());
                    property.setForSale(newProperty.getForSale());
                    property.setPostalCode(newProperty.getPostalCode());
                    property.setInterior(newProperty.getInterior());
                    property.setRooms(newProperty.getRooms());
                    repo.save(property);
                    return true;
                }
            }
        return false;
    }
}
