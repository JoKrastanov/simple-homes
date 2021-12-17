package com.example.simple_homes.repository.property_repository.property_repository_interfaces;

import com.example.simple_homes.classes.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPropertyRepository extends JpaRepository<Property, Long> {
}
