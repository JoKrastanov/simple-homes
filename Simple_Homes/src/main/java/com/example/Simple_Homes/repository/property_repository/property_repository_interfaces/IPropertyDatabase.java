package com.example.simple_homes.repository.property_repository.property_repository_interfaces;

import com.example.simple_homes.classes.Property;

import java.util.List;

public interface IPropertyDatabase {
    List<Property> loadAllProperties();
    Property loadProperty(Long id);
    boolean deleteProperty(Long id);
    boolean createProperty(Property property);
    boolean updateProperty(Property property);
}
