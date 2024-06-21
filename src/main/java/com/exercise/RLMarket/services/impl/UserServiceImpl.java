package com.exercise.RLMarket.services.impl;

import com.exercise.RLMarket.DTOs.UserDTO;
import com.exercise.RLMarket.enteties.enums.Role;
import com.exercise.RLMarket.enteties.User;
import com.exercise.RLMarket.mappers.UserMapper;
import com.exercise.RLMarket.repositories.UserRepository;
import com.exercise.RLMarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(User user) {
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(new User());
    }

    @Override
    public UserDTO getUserById(int id) {
        return UserMapper.userToUserDTO(userRepository.findById(id).get());
    }
}
