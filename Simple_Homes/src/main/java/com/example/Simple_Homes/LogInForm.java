package com.example.Simple_Homes;

import org.springframework.core.style.ToStringCreator;

public class LogInForm {
    String email;
    String password;

    public LogInForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {return  email;}
    public String getPassword() {return password;}

}
