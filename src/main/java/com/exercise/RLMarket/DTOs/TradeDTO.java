package com.exercise.RLMarket.DTOs;

import com.exercise.RLMarket.enteties.Item;
import com.exercise.RLMarket.enteties.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TradeDTO {
    private int id;
    private UserDTO user;
    private Date date;
    private ItemDTO giveItem;
    private int giveAmount;
    private ItemDTO getItem;
    private int getAmount;

    @Autowired
    public TradeDTO(int id, UserDTO user, ItemDTO giveItem, int giveAmount, ItemDTO getItem, int getAmount) {
        this.id = id;
        this.user = user;
        this.date = new Date();
        this.giveItem = giveItem;
        this.giveAmount = giveAmount;
        this.getItem = getItem;
        this.getAmount = getAmount;
    }
}

