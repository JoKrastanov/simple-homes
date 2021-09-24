package com.example.Simple_Homes.intefaces.PropertyInterfaces;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;

import java.util.List;

public interface IPropertyManager {
    public List<Property> getProperties();
    Property getProperty(int id);
    public boolean removeProperty(int id);
    public boolean addProperty(Property property);
    public boolean updateProperty(Property property);
}
