package com.example.Simple_Homes.intefaces.PropertyInterfaces;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;

import java.util.List;

public interface IPropertyService {
    List<Property> getProperties();
    Property getProperty(Long id);
    boolean removeProperty(Long id);
    boolean addProperty(Property property);
    boolean updateProperty(Property property);
    List<Property> getPropertiesType(String type);
    List<Property> getPropertiesAddress(String address);
    List<Property> getPropertiesTypeAndAddress(String type, String address);
}
