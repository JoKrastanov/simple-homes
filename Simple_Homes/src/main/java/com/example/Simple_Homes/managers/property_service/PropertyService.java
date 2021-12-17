package com.example.simple_homes.managers.property_service;

import com.example.simple_homes.classes.Property;
import com.example.simple_homes.managers.property_service.property_service_interfaces.IPropertyService;
import com.example.simple_homes.repository.property_repository.property_repository_interfaces.IPropertyDatabase;
import com.example.simple_homes.requests.FilterAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyService implements IPropertyService {

    private IPropertyDatabase propertyDatabase;

    @Override
    public List<Property> getProperties() {
        return propertyDatabase.loadAllProperties();
    }

    @Override
    public Property getProperty(Long id) {
        return propertyDatabase.loadProperty(id);
    }

    @Override
    public boolean removeProperty(Long id) {
        return propertyDatabase.deleteProperty(id);
    }

    @Override
    public boolean addProperty(Property property) {
        return propertyDatabase.createProperty(property);
    }

    @Override
    public boolean updateProperty(Property property) {
        return propertyDatabase.updateProperty(property);
    }

    @Override
    public List<Property> filterProperties(FilterAccountRequest request) {
        List<Property> filteredProperties = getProperties();
        if (!request.getLocation().equals("")) {
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
            default:
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
        int maxSize = request.getAproxSize() + 3;
        int minSize = request.getAproxSize() - 3;
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

