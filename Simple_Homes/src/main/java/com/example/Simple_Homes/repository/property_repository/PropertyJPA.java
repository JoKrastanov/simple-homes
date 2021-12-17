package com.example.simple_homes.repository.property_repository;

import com.example.simple_homes.classes.Property;
import com.example.simple_homes.repository.property_repository.property_repository_interfaces.IPropertyDatabase;
import com.example.simple_homes.repository.property_repository.property_repository_interfaces.IPropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PropertyJPA implements IPropertyDatabase {

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
