package com.example.Simple_Homes.intefaces.PropertyInterfaces;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.List;

public interface IPropertyDatabase {
    public List<Property> loadAllProperties();
    public Property loadProperty(int id);
    public boolean deleteProperty(int id);
    public boolean createProperty(Property property);
    public boolean updateProperty(Property property);
}
