package com.example.simple_homes.managers.viewing_service.viewing_service_interfaces;

import com.example.simple_homes.classes.Viewing;

import java.util.List;

public interface IViewingService {
    boolean createViewing(Viewing viewing);
    boolean deleteViewing(Long id);
    List<Viewing> getPropertyViewings(Long id);
    List<Viewing> getAccountViewings(Long id);
}
