package com.example.Simple_Homes.managers.PropertyService.PropertyServiceInterfaces;

import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.requests.FilterAccountRequest;

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
