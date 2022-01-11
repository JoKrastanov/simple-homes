package com.example.simple_homes.repository.viewing_repository;

import com.example.simple_homes.classes.Viewing;
import com.example.simple_homes.repository.viewing_repository.viewing_repository_interfaces.IViewingDatabase;
import com.example.simple_homes.repository.viewing_repository.viewing_repository_interfaces.IViewingRepository;
import lombok.RequiredArgsConstructor;
import net.minidev.asm.ConvertDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
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
        List<Viewing> accViewings = repo.findViewingByAccountId(accountId);
        return checkViewings(accViewings);
    }

    private List<Viewing> checkViewings(List<Viewing> allViewings) {
        List<Viewing> viewings = allViewings;
        for (Viewing viewing : viewings) {
            if (viewing.getViewingDate().isBefore(LocalDateTime.now())) {
                viewings.remove(viewing);
                deleteViewing(viewing.getId());
            }
        }
        return viewings;
    }
}
