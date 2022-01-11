package com.example.simple_homes.managers.viewing_service;

import com.example.simple_homes.classes.Viewing;
import com.example.simple_homes.managers.viewing_service.viewing_service_interfaces.IViewingService;
import com.example.simple_homes.repository.viewing_repository.viewing_repository_interfaces.IViewingDatabase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ViewingService implements IViewingService {

    @Autowired
    private final IViewingDatabase dataClass;

    @Override
    public boolean createViewing(Viewing viewing) {
        return dataClass.createViewing(viewing);
    }

    @Override
    public boolean deleteViewing(Long id) {
        return dataClass.deleteViewing(id);
    }

    @Override
    public List<Viewing> getPropertyViewings(Long id) {
        return dataClass.getViewingsByPropertyId(id);
    }

    @Override
    public List<Viewing> getAccountViewings(Long id) {
        return dataClass.getViewingsByAccountId(id);
    }


}
