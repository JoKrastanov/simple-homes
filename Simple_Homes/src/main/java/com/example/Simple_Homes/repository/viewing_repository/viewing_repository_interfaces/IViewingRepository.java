package com.example.simple_homes.repository.viewing_repository.viewing_repository_interfaces;

import com.example.simple_homes.classes.Viewing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IViewingRepository  extends JpaRepository<Viewing, Long> {
     List<Viewing> findViewingByAccountId(Long accountId);
     List<Viewing> findViewingByPropertyId(Long propertyId);
}
