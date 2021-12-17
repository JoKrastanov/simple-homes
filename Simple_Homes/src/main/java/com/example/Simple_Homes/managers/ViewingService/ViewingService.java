package com.example.Simple_Homes.managers.ViewingService;

import com.example.Simple_Homes.classes.Viewing;
import com.example.Simple_Homes.managers.ViewingService.ViewingServiceInterfaces.IViewingService;
import com.example.Simple_Homes.repository.ViewingRepository.ViewingRepositoryInterfaces.IViewingDatabase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ViewingService implements IViewingService {

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
