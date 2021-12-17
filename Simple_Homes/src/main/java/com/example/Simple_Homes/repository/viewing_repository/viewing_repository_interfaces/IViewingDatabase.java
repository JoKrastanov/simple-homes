package com.example.simple_homes.repository.viewing_repository.viewing_repository_interfaces;

import com.example.simple_homes.classes.Viewing;

import java.util.List;

public interface IViewingDatabase {
    boolean createViewing(Viewing viewing);
    boolean deleteViewing(Long id);
    List<Viewing> getViewingsByPropertyId(Long propertyId);
    List<Viewing> getViewingsByAccountId(Long accountId);
}
