package com.training.authenticationservice.service;

import com.training.authenticationservice.dto.UserDTO;

import com.training.authenticationservice.feignclient.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomUserDetailsService implements UserDetailsService {



    @Autowired
    private UserClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {


        UserDTO user =userFeignClient.getUserByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                List.of(
                        new SimpleGrantedAuthority(
                                user.getRole()))
        );
    }
}