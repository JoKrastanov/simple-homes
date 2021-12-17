package com.example.simple_homes.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}
