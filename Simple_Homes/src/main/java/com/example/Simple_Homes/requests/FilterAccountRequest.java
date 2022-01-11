package com.example.simple_homes.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class FilterAccountRequest {
    private String type;
    private String location;
    private Integer aproxSize;
    private Integer minPrice;
    private Integer maxPrice;
    private String interior;
}
