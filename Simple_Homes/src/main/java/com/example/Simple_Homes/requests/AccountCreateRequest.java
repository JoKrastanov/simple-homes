package com.example.Simple_Homes.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountCreateRequest {

    private String username;
    private String password;
    private String name;
    private String phoneNumber;
}
