package com.example.Simple_Homes.authentication;

import com.example.Simple_Homes.classes.Account;
import com.example.Simple_Homes.managers.AccountService.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationAccountDetailService implements UserDetailsService {
    private final AccountService userService;
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account apiUser = userService.findByEmail(username);
        if (apiUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(apiUser.getEmail(), apiUser.getPassword(), Collections.emptyList());
    }
}