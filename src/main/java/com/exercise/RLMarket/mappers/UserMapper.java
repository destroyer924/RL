package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.UserDTO;
import com.exercise.RLMarket.enteties.User;
import com.exercise.RLMarket.repositories.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public class UserMapper {
    public static UserDTO userToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .epicGames(user.getEpicGames())
                .role(user.getRole())
                .build();
    }

    public static User userDTOToUser(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .email(userDTO.getEmail())
                .epicGames(userDTO.getEpicGames())
                .password("password")
                .role(userDTO.getRole())
                .build();
    }
}
