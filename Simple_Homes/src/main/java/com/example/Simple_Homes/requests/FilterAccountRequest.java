package com.example.Simple_Homes.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class FilterAccountRequest {
    private List<String> types;
    private String location;
    private Integer aproxSize;
    private Integer minPrice;
    private Integer maxPrice;
    private List<String> interiors;
}
