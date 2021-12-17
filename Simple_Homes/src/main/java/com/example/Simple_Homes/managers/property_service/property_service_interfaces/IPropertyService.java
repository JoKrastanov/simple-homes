package com.example.simple_homes.managers.property_service.property_service_interfaces;

import com.example.simple_homes.classes.Property;
import com.example.simple_homes.requests.FilterAccountRequest;

import java.util.List;

public interface IPropertyService {
    List<Property> getProperties();
    Property getProperty(Long id);
    boolean removeProperty(Long id);
    boolean addProperty(Property property);
    boolean updateProperty(Property property);
    List<Property> filterProperties(FilterAccountRequest request);
    List<Property> searchPropertiesByLocation(String location);
}
