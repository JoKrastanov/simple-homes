package com.example.Simple_Homes.services;

import com.example.Simple_Homes.classes.Property;

import java.util.List;

public interface IPropertyService {
    public List<Property> getProperties();
    Property getProperty(int id);
    public boolean removeProperty(int id);
    public boolean addProperty(Property property);
    public boolean updateProperty(Property property);
    public List<Property> getPropertiesType(String type);
    public List<Property> getPropertiesAddress(String address);
    public List<Property> getPropertiesTypeAndAddress(String type, String address);
}
