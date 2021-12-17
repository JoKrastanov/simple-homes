package com.example.simple_homes.repository.viewing_repository;

import com.example.simple_homes.classes.Viewing;
import com.example.simple_homes.repository.viewing_repository.viewing_repository_interfaces.IViewingDatabase;
import com.example.simple_homes.repository.viewing_repository.viewing_repository_interfaces.IViewingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ViewingJPA implements IViewingDatabase {

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
