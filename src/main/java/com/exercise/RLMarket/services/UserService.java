package com.exercise.RLMarket.services;

import com.exercise.RLMarket.DTOs.UserDTO;
import com.exercise.RLMarket.enteties.User;

public interface UserService {
    void createUser(User user);

    User findByEmail(String email);
    UserDTO getUserById(int id);
}
