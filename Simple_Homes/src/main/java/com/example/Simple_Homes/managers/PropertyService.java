package com.example.Simple_Homes.managers;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyDatabase;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyManager;
import com.example.Simple_Homes.repository.TestDataProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropertyManager implements IPropertyManager {

    IPropertyDatabase PROPERTY_DATABASE;

    public PropertyManager(IPropertyDatabase propertyDatabase)
    {PROPERTY_DATABASE = propertyDatabase;}

    @Override
    public List<Property> getProperties() {return PROPERTY_DATABASE.loadAllProperties();}

    @Override
    public Property getProperty(int id) {return PROPERTY_DATABASE.loadProperty(id);}

    @Override
    public boolean removeProperty(int id) {return PROPERTY_DATABASE.deleteProperty(id);}

    @Override
    public boolean addProperty(Property property) {return PROPERTY_DATABASE.createProperty(property);}

    @Override
    public boolean updateProperty(Property property) {return PROPERTY_DATABASE.updateProperty(property);}

    @Override
    public List<Property> getPropertiesType(String type) {return PROPERTY_DATABASE.getPropertiesType(type);}
}
