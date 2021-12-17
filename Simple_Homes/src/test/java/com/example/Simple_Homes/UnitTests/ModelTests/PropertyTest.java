package com.example.simple_homes.UnitTests.ModelTests;

import com.example.simple_homes.classes.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyTest {
    String DEFAULT_TYPE = "Room";
    Double DEFAULT_PRICE = 400.0;
    String DEFAULT_DESCRIPTION = "desc";
    Boolean forSale = false;
    Long DEFAULT_PUBLISHERID = 1L;
    String DEFAULT_ADDRESS = "Heezerweg 155";
    String DEFAULT_POSTACODE = "5656AB";
    String DEFAULT_CITY = "Eindhoven";
    Integer DEFAULT_SIZE = 12;
    Integer DEFAULT_ROOMS = 1;
    String DEFAULT_INTERIOR = "Furnished";

    Property Test_Property = new Property(1L, DEFAULT_TYPE, DEFAULT_PRICE, false, DEFAULT_DESCRIPTION, forSale, DEFAULT_PUBLISHERID,DEFAULT_ADDRESS, DEFAULT_POSTACODE, DEFAULT_CITY, DEFAULT_SIZE, "2021/11/25", "2021/11/25", DEFAULT_ROOMS, DEFAULT_INTERIOR);

    @Test
    void TestConstructorSuccessful()
    {
        Property property = new Property(1L, DEFAULT_TYPE, DEFAULT_PRICE, false, DEFAULT_DESCRIPTION, forSale, DEFAULT_PUBLISHERID,DEFAULT_ADDRESS, DEFAULT_POSTACODE, DEFAULT_CITY, DEFAULT_SIZE, "2021/11/25", "2021/11/25", DEFAULT_ROOMS, DEFAULT_INTERIOR);

        assertEquals(DEFAULT_PRICE, property.getPrice());
        assertEquals(DEFAULT_TYPE, property.getType());
        assertEquals(DEFAULT_ROOMS, property.getRooms());

    }

    @Test
    void TestSetTypeSuccessful()
    {
        String newType = "House";
        Test_Property.setType(newType);

        assertEquals(newType, Test_Property.getType());
    }
    @Test
    void TestSetTypeUnsuccessful()
    {
        String newType = "House";
        Test_Property.setType(newType);

        Assertions.assertNotEquals(DEFAULT_TYPE, Test_Property.getType());
    }

    @Test
    void TestSetPriceSuccessful()
    {
        Double newPrice = 500D;
        Test_Property.setPrice(newPrice);

        assertEquals(newPrice, Test_Property.getPrice());
    }
    @Test
    void TestSetPriceUnsuccessful()
    {
        Double newPrice = 500D;
        Test_Property.setPrice(newPrice);

        Assertions.assertNotEquals(DEFAULT_PRICE, Test_Property.getPrice());
    }

    @Test
    void TestSetDescSuccessful()
    {
        String newDesc = "new desc";
        Test_Property.setDescription(newDesc);

        assertEquals(newDesc, Test_Property.getDescription());
    }
    @Test
    void TestSetDescUnsuccessful()
    {
        String newDesc = "new desc";
        Test_Property.setDescription(newDesc);

        Assertions.assertNotEquals(DEFAULT_DESCRIPTION, Test_Property.getDescription());
    }

    @Test
    void TestSetAddressSuccessful()
    {
        String newAddress = "Johannes van der Waalsweg";
        Test_Property.setAddress(newAddress);

        assertEquals(newAddress, Test_Property.getAddress());
    }
    @Test
    void TestSetAddressUnsuccessful()
    {
        String newAddress = "Johannes van der Waalsweg";
        Test_Property.setAddress(newAddress);

        Assertions.assertNotEquals(DEFAULT_ADDRESS, Test_Property.getAddress());
    }

    @Test
    void TestSetPostalCodeSuccessful()
    {
        String newPostalCode = "1234AB";
        Test_Property.setPostalCode(newPostalCode);

        assertEquals(newPostalCode, Test_Property.getPostalCode());
    }
    @Test
    void TestSetPostalCodeUnsuccessful()
    {
        String newPostalCode = "1234AB";
        Test_Property.setPostalCode(newPostalCode);

        Assertions.assertNotEquals(DEFAULT_POSTACODE, Test_Property.getPostalCode());
    }

    @Test
    void TestSetCitySuccessful()
    {
        String newCity = "Amsterdam";
        Test_Property.setCity(newCity);

        assertEquals(newCity, Test_Property.getCity());
    }
    @Test
    void TestSetCityUnsuccessful()
    {
        String newCity = "Amsterdam";
        Test_Property.setCity(newCity);

        Assertions.assertNotEquals(DEFAULT_CITY, Test_Property.getCity());
    }

    @Test
    void TestSetSizeSuccessful()
    {
        Integer newSize = 16;
        Test_Property.setSize(newSize);

        assertEquals(newSize, Test_Property.getSize());
    }
    @Test
    void TestSetSizeUnsuccessful()
    {
        Integer newSize = 16;
        Test_Property.setSize(newSize);

        Assertions.assertNotEquals(DEFAULT_SIZE, Test_Property.getSize());
    }

    @Test
    public void TestSetRoomsSuccessful()
    {
        Integer newRooms = 2;
        Test_Property.setRooms(newRooms);

        assertEquals(newRooms, Test_Property.getRooms());
    }
    @Test
    public void TestSetRoomsUnsuccessful()
    {
        Integer newRooms = 2;
        Test_Property.setRooms(newRooms);

        Assertions.assertNotEquals(DEFAULT_ROOMS, Test_Property.getRooms());
    }

    @Test
    public void TestSetInteriorSuccessful()
    {
        String newInterior = "Unfurnished";
        Test_Property.setInterior(newInterior);

        assertEquals(newInterior, Test_Property.getInterior());
    }
    @Test
    public void TestSetInteriorUnsuccessful()
    {
        String newInterior = "Unfurnished";
        Test_Property.setInterior(newInterior);

        Assertions.assertNotEquals(DEFAULT_INTERIOR, Test_Property.getInterior());
    }




}
