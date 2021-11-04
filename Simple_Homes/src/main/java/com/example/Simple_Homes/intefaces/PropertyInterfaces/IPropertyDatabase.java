package com.example.Simple_Homes.intefaces.PropertyInterfaces;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.List;

public interface IPropertyDatabase {
    List<Property> loadAllProperties();
    Property loadProperty(Long id);
    boolean deleteProperty(Long id);
    boolean createProperty(Property property);
    boolean updateProperty(Property property);
}
