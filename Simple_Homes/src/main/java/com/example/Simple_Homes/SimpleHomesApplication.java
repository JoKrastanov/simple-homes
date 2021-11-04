package com.example.Simple_Homes;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.classes.Property;
import com.example.Simple_Homes.controller.AccountController;
import com.example.Simple_Homes.controller.PropertyController;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyDatabase;
import com.example.Simple_Homes.intefaces.PropertyInterfaces.IPropertyService;
import com.example.Simple_Homes.managers.PropertyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleHomesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleHomesApplication.class, args);
	}
	
}
