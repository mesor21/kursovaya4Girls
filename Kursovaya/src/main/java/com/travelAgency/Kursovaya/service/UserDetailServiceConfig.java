package com.travelAgency.Kursovaya.service;

import com.sun.istack.NotNull;
import com.travelAgency.Kursovaya.entity.UserSystem;
import com.travelAgency.Kursovaya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailServiceConfig implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(@NotNull String login) throws UsernameNotFoundException {
        if(userRepository.findByLogin(login)==null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        UserSystem userSystem=userRepository.findByLogin(login);
        GrantedAuthority authority = new SimpleGrantedAuthority(userSystem.getRoles().getRole());
        UserDetails userDetails = (UserDetails) new User( userSystem.getLogin(), userSystem.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}
