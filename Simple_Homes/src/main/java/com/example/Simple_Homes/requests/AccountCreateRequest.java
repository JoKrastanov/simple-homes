package com.example.Simple_Homes.requests;

import lombok.Data;

@Data
public class AccountCreateRequest {

    private String username;
    private String password;
    private String name;
    private String phoneNumber;
}
