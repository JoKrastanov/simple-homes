package com.example.Simple_Homes.repository.PropertyRepository.PropertyRepositoryInterfaces;

import com.example.Simple_Homes.classes.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPropertyRepository extends JpaRepository<Property, Long> {
}
