package com.exercise.RLMarket.DTOs;


import com.exercise.RLMarket.enteties.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private int id;
    private String email;
    private String epicGames;
    private Role role;
}
