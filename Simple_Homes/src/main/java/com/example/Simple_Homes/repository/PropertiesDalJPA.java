package com.example.Simple_Homes.repository;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.repositoryInterfaces.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TestDataProperties implements IPropertyRepository {

    @Autowired
    private static final List<Property> propertyList = new ArrayList<>();

    public TestDataProperties() {
        Date testDate = new Date(2021, Calendar.JULY, 19);
        propertyList.add(new Property("Room", 400, new Account("Test User 4", "tu4@gmail.com", "+31874052359", "password"), "Heezerweg 186", "5614HJ", "Eindhoven", 12, testDate, "Come see it", false, 1, "Furnished"));
        propertyList.add(new Property("House", 2050, new Account("Test User 4", "tu4@gmail.com", "+31874052359", "password"), "Heezerweg 155", "5614JD", "Groningen", 80, testDate, "description", true, 4, "Upholstered"));
        propertyList.add(new Property("Studio", 850, new Account("Test User 4", "tu4@gmail.com", "+31874052359", "password"), "Boschdijk 213", "2150BW", "Eindhoven", 12, testDate, "Come see it", false, 1, "Furnished"));
        propertyList.add(new Property("Apartment", 1100, new Account("Test User 4", "tu4@gmail.com", "+31874052359", "password"), "Johannes van der Waalsweg 86", "5416CB", "Eindhoven", 12, testDate, "Come see it", false, 1, "Furnished"));
        propertyList.add(new Property("Room", 450, new Account("Test User 4", "tu4@gmail.com", "+31874052359", "password"), "Pioneerstraat 60", "6060AB", "Amsterdam", 12, testDate, "Come see it", false, 1, "Furnished"));
        propertyList.add(new Property("Room", 380, new Account("Test User 4", "tu4@gmail.com", "+31874052359", "password"), "Markonilaan 10A", "1234YZ", "Eindhoven", 12, testDate, "Come see it", false, 1, "Furnished"));

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
                    property.setDescription(newProperty.getDescription());
                    property.setPublisher(newProperty.getPublisher());
                    property.setForSale(newProperty.getForSale());
                    property.setPostalCode(newProperty.getPostalCode());
                    property.setInterior(newProperty.getInterior());
                    property.setRooms(newProperty.getRooms());

                    return true;
                }
            }
        return false;
    }
}
