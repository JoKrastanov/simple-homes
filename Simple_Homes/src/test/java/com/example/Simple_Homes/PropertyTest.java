package com.example.Simple_Homes;

import com.example.Simple_Homes.classes.Property;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;
import org.springframework.test.context.TestConstructor;
import org.springframework.util.Assert;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertyTest {
    String DEFAULT_TYPE = "Room";
    double DEFAULT_PRICE = 400;
    String DEFAULT_DESCRIPTION = "desc";
    boolean forSale = false;
    Long DEFAULT_PUBLISHERID = 1L;
    String DEFAULT_ADDRESS = "Heezerweg 155";
    String DEFAULT_POSTACODE = "5656AB";
    String DEFAULT_CITY = "Eindhoven";
    int DEFAULT_SIZE = 12;
    int DEFAULT_ROOMS = 1;
    String DEFAULT_INTERIOR = "Furnished";

    Property Test_Property = new Property(DEFAULT_TYPE, DEFAULT_PRICE, DEFAULT_PUBLISHERID, DEFAULT_ADDRESS, DEFAULT_POSTACODE, DEFAULT_CITY, DEFAULT_SIZE, "available", DEFAULT_DESCRIPTION, forSale, DEFAULT_ROOMS, DEFAULT_INTERIOR, "test");

    @Test
    public void TestConstructorSuccessful()
    {
        Property property = new Property(DEFAULT_TYPE, DEFAULT_PRICE,DEFAULT_PUBLISHERID, DEFAULT_ADDRESS, DEFAULT_POSTACODE, DEFAULT_CITY, DEFAULT_SIZE, "available", DEFAULT_DESCRIPTION,forSale, DEFAULT_ROOMS,DEFAULT_INTERIOR, "test");

        assertEquals(DEFAULT_PRICE, property.getPrice());
        assertEquals(DEFAULT_TYPE, property.getType());
        assertEquals(DEFAULT_ROOMS, property.getRooms());

    }

    @Test
    public void TestSetTypeSuccessfull()
    {
        String newType = "House";
        Test_Property.setType(newType);

        assertEquals(newType, Test_Property.getType());
    }


}
