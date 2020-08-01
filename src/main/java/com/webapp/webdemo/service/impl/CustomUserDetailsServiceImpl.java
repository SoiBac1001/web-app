package com.webapp.webdemo.service.impl;

import com.webapp.webdemo.entities.security.User;
import com.webapp.webdemo.repository.UserRepository;
import com.webapp.webdemo.security.dto.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return UserPrincipal.create(user);
    }

    public UserDetails loadUserByUserNo(Long userNo){
        User user = userRepository.findById(userNo)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with user no: " + userNo));
        return UserPrincipal.create(user);
    }
}
