package com.java.springboot.Pfa.ProjetPfa.auth;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.springboot.Pfa.ProjetPfa.Repository.UserRepository;
import com.java.springboot.Pfa.ProjetPfa.model.User;




@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        User user = userRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return (UserDetails) user;
    }
}
