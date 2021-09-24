package com.example.Simple_Homes.repository;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.intefaces.AccountInterfaces.IAccountDatabase;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyDatabase;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TestDataProperties implements IPropertyDatabase {

    private static final List<Property> propertyList = new ArrayList<>();

    public TestDataProperties() {
        Date testDate = new Date(2021, Calendar.JULY, 19);
        propertyList.add(new Property(1, "Room", 400, new Account("Test User 4", "tu4@gmail.com", "+31874052359", "password"), "Heezerweg 186", "5614HJ", "Eindhoven", 12, testDate));
        propertyList.add(new Property(2, "Room", 450, new Account("Test User 4", "tu4@gmail.com", "+31874052359", "password"), "Heezerweg 155", "5614JD", "Eindhoven", 12, testDate));
    }

    @Override
    public List<Property> loadAllProperties() {
        return propertyList;
    }

    @Override
    public Property loadProperty(int id) {
        for (Property property : propertyList)
        {
            if(property.getId() == id)
            {return property;}
        }
        return null;
    }

    @Override
    public boolean deleteProperty(int id) {
        for (Property property : propertyList)
        {
            if(property.getId() == id)
            {
                propertyList.remove(property);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean createProperty(Property property) {
        if(!propertyList.contains(property)) {
            propertyList.add(property);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateProperty(Property newProperty) {
            for (Property property : propertyList) {
                if (property.getId() == newProperty.getId()) {
                    property.setAddress(newProperty.getAddress());
                    property.setAvailability(newProperty.getAvailability());
                    property.setCity(newProperty.getCity());
                    property.setPrice(newProperty.getPrice());
                    property.setSize(newProperty.getSize());
                    property.setDateAvailable(newProperty.getDateAvailable());
                    property.setType(newProperty.getType());
                    return true;
                }
            }
        return false;
    }
}
