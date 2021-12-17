package com.example.Simple_Homes.repository.ViewingRepository.ViewingRepositoryInterfaces;

import com.example.Simple_Homes.classes.Viewing;

import java.util.List;

public interface IViewingDatabase {
    boolean createViewing(Viewing viewing);
    boolean deleteViewing(Long id);
    List<Viewing> getViewingsByPropertyId(Long propertyId);
    List<Viewing> getViewingsByAccountId(Long accountId);
}
