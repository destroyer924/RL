package com.exercise.RLMarket.security;

import com.exercise.RLMarket.enteties.User;
import com.exercise.RLMarket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElse(null);
        System.out.println(email + "\n" + user);
        if (user != null) {
            return user;
        }

        System.out.println("\n\n\ntest\n\n");
        throw new UsernameNotFoundException("Invalid username");
    }
}
