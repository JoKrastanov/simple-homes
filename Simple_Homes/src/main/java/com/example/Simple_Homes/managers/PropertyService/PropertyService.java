package com.example.Simple_Homes.managers.PropertyService;

import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.managers.PropertyService.PropertyServiceInterfaces.IPropertyService;
import com.example.Simple_Homes.repository.PropertyRepository.PropertyRepositoryInterfaces.IPropertyDatabase;
import com.example.Simple_Homes.requests.FilterAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    private IPropertyDatabase PROPERTY_DATABASE;

    public PropertyService(IPropertyDatabase propertyDatabase) {
        PROPERTY_DATABASE = propertyDatabase;
    }

    @Override
    public List<Property> getProperties() {
        return PROPERTY_DATABASE.loadAllProperties();
    }

    @Override
    public Property getProperty(Long id) {
        return PROPERTY_DATABASE.loadProperty(id);
    }

    @Override
    public boolean removeProperty(Long id) {
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
    public List<Property> filterProperties(FilterAccountRequest request) {
        List<Property> filteredProperties = getProperties();
        if (request.getLocation() != "") {
            updateFilteredList(filteredProperties, request, 2);
        }
        if (request.getMinPrice() > 0 && request.getMaxPrice() > 1) {
            updateFilteredList(filteredProperties, request, 1);
        }
        if (request.getAproxSize() > 0) {
            updateFilteredList(filteredProperties, request, 0);
        }
        if (!request.getInteriors().isEmpty()) {
            updateFilteredList(filteredProperties, request, 3);
        }
        if (!request.getTypes().isEmpty()) {
            updateFilteredList(filteredProperties, request,4);
        }
        return filteredProperties;
    }

    @Override
    public List<Property> searchPropertiesByLocation(String location) {
        List<Property> properties = getProperties();
        properties.removeIf(property -> !property.getCity().toLowerCase().trim().startsWith(location.toLowerCase().trim())
                && !property.getAddress().toLowerCase().trim().startsWith(location.toLowerCase().trim())
                && !property.getPostalCode().toLowerCase().trim().startsWith(location.toLowerCase().trim()));
        return properties;
    }

        //region Additional Methods
    private void updateFilteredList(List<Property> properties, FilterAccountRequest request, int filterType) {
        List<Property> temp = new ArrayList<>();
        switch (filterType)
        {
            case 0:
                temp.addAll(properties);
                properties.clear();
                properties.addAll(filterSize(temp, request));
                break;
            case 1:
                temp.addAll(properties);
                properties.clear();
                properties.addAll(filterPrice(temp, request));
                break;
            case 2:
                temp.addAll(properties);
                properties.clear();
                properties.addAll(filterLocation(temp, request));
                break;
            case 3:
                temp.addAll(properties);
                properties.clear();
                properties.addAll(filterInterior(temp, request));
                break;
            case 4:
                temp.addAll(properties);
                properties.clear();
                properties.addAll(filterType(temp, request));
                break;
        }
    }

    private List<Property> filterLocation(List<Property> properties, FilterAccountRequest request) {
        properties.removeIf(property -> !property.getCity().toLowerCase().trim().contains(request.getLocation().toLowerCase().trim())
        && !property.getAddress().toLowerCase().trim().contains(request.getLocation().toLowerCase().trim())
        && !property.getPostalCode().toLowerCase().trim().contains(request.getLocation().toLowerCase().trim()));
        return properties;
    }
    private List<Property> filterPrice(List<Property> properties, FilterAccountRequest request) {
        properties.removeIf(property -> property.getPrice() < request.getMinPrice() || property.getPrice() > request.getMaxPrice());
        return properties;
    }
    private List<Property> filterSize(List<Property> properties, FilterAccountRequest request) {
        double maxSize = request.getAproxSize() + 3;
        double minSize = request.getAproxSize() - 3;
        properties.removeIf(property -> property.getSize() > maxSize || property.getSize() < minSize);
        return properties;
    }
    private List<Property> filterInterior(List<Property> properties, FilterAccountRequest request) {
        properties.removeIf(property -> !request.getInteriors().contains(property.getInterior()));
        return properties;
    }
    private List<Property> filterType(List<Property> properties, FilterAccountRequest request) {
        properties.removeIf(property -> !request.getTypes().contains(property.getType()));
        return properties;
    }
//endregion
}

