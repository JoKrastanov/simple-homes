package com.example.Simple_Homes.managers;

import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyDatabase;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class PropertyService implements IPropertyService {

    IPropertyDatabase PROPERTY_DATABASE;

    public PropertyService(IPropertyDatabase propertyDatabase) {
        PROPERTY_DATABASE = propertyDatabase;
    }

    @Override
    public List<Property> getProperties() {
        return PROPERTY_DATABASE.loadAllProperties();
    }

    @Override
    public Property getProperty(int id) {
        return PROPERTY_DATABASE.loadProperty(id);
    }

    @Override
    public boolean removeProperty(int id) {
        return PROPERTY_DATABASE.deleteProperty(id);
    }

    @Override
    public boolean addProperty(Property property) {
        return PROPERTY_DATABASE.createProperty(property);
    }

    @Override
    public boolean updateProperty(Property property) {
        return PROPERTY_DATABASE.updateProperty(property);
    }

    @Override
    public List<Property> getPropertiesType(String type) {

        List<Property> temp = new ArrayList<>();

        for (Property property : getProperties()) {
            if (property.getType().toLowerCase().replace(" ", "").contains(type.toLowerCase().replace(" ", ""))) {
                temp.add(property);
            }
        }
        return temp;
    }

    @Override
    public List<Property> getPropertiesAddress(String address) {

        List<Property> temp = new ArrayList<>();

        for (Property property : getProperties()) {
            if (property.getAddress().toLowerCase().replace(" ", "").contains(address.toLowerCase().replace(" ", "")) || property.getCity().toLowerCase().replace(" ", "").contains(address.toLowerCase().replace(" ", "")) || property.getPostalCode().toLowerCase().replace(" ", "").contains(address.toLowerCase().replace(" ", ""))) {
                temp.add(property);
            }
        }
        return temp;
    }

    @Override
    public List<Property> getPropertiesTypeAndAddress(String location, String type) {

        List<Property> temp = new ArrayList<>();

        for (Property property : getProperties()) {
            if (property.getAddress().toLowerCase().replace(" ", "").contains(location.toLowerCase().replace(" ", "")) || property.getCity().toLowerCase().replace(" ", "").contains(location.toLowerCase().replace(" ", "")) || property.getPostalCode().toLowerCase().replace(" ", "").contains(location.toLowerCase().replace(" ", ""))) {
                if (property.getType().toLowerCase().replace(" ", "").contains(type.toLowerCase().replace(" ", ""))) {
                    temp.add(property);
                }
            }
        }
        return temp;
    }
}
