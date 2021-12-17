package com.example.Simple_Homes.managers.ViewingService.ViewingServiceInterfaces;

import com.example.Simple_Homes.classes.Viewing;

import java.util.List;

public interface IViewingService {
    boolean createViewing(Viewing viewing);
    boolean deleteViewing(Long id);
    List<Viewing> getPropertyViewings(Long id);
    List<Viewing> getAccountViewings(Long id);
}
