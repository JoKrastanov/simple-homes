package com.example.Simple_Homes.repository.PropertyRepository.PropertyRepositoryInterfaces;

import com.example.Simple_Homes.classes.Property;

import java.util.List;

public interface IPropertyDatabase {
    List<Property> loadAllProperties();
    Property loadProperty(Long id);
    boolean deleteProperty(Long id);
    boolean createProperty(Property property);
    boolean updateProperty(Property property);
}
