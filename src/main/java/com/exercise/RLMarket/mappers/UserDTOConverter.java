package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.DTOs.UserDTO;
import com.exercise.RLMarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter implements Converter<String, UserDTO> {

    @Autowired
    private UserService userService;

    @Override
    public UserDTO convert(String source) {
        try {
            int userId = Integer.parseInt(source);
            System.out.println("Converting user ID: " + userId);
            UserDTO userDTO
                    = userService.getUserById(userId);
//            =UserMapper.userToUserDTO(userService.findByEmail(source));
            System.out.println("Converted userDTO: " + userDTO);
            return userDTO;
        } catch (NumberFormatException e) {
            System.out.println("Failed to convert user ID: " + source);
            // Handle the exception appropriately, e.g., log it or return a default UserDTO
            return null; // You might want to return a default UserDTO or handle the exception
        }
    }
}

