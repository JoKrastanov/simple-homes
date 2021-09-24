package com.example.Simple_Homes.managers;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyManager;
import com.example.Simple_Homes.repository.TestDataProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropertyManager implements IPropertyManager {
    TestDataProperties TEST_DATA_PROPERTIES = new TestDataProperties();

    @Override
    public List<Property> getProperties() {return TEST_DATA_PROPERTIES.loadAllProperties();}

    @Override
    public Property getPropery(int id) {return TEST_DATA_PROPERTIES.loadProperty(id);}

    @Override
    public boolean removeProperty(int id) {return TEST_DATA_PROPERTIES.deleteProperty(id);}

    @Override
    public boolean addProperty(Property property) {return TEST_DATA_PROPERTIES.createProperty(property);}

    @Override
    public boolean updateProperty(Property property) {return TEST_DATA_PROPERTIES.updateProperty(property);}
}
