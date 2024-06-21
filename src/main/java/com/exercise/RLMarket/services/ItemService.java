package com.exercise.RLMarket.services;

import com.exercise.RLMarket.DTOs.ItemDTO;

import java.util.List;

public interface ItemService {
    List<ItemDTO> getItems();

    ItemDTO getItem(int id);
}
