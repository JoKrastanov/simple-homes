package com.example.Simple_Homes.repository.ViewingRepository.ViewingRepositoryInterfaces;

import com.example.Simple_Homes.classes.Viewing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IViewingRepository  extends JpaRepository<Viewing, Long> {
     List<Viewing> findViewingByAccountId(Long accountId);
     List<Viewing> findViewingByPropertyId(Long propertyId);
}
