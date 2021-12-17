package com.example.Simple_Homes.repository.ViewingRepository;

import com.example.Simple_Homes.classes.Viewing;
import com.example.Simple_Homes.repository.ViewingRepository.ViewingRepositoryInterfaces.IViewingDatabase;
import com.example.Simple_Homes.repository.ViewingRepository.ViewingRepositoryInterfaces.IViewingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ViewingJPA implements IViewingDatabase {

    @Autowired
    IViewingRepository repo;

    @Override
    public boolean createViewing(Viewing viewing) {
        repo.save(viewing);
        return true;
    }

    @Override
    public boolean deleteViewing(Long id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public List<Viewing> getViewingsByPropertyId(Long propertyId) {
        return repo.findViewingByPropertyId(propertyId);
    }

    @Override
    public List<Viewing> getViewingsByAccountId(Long accountId) {
        return repo.findViewingByAccountId(accountId);
    }
}
