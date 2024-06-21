package com.exercise.RLMarket.services.impl;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.Item;
import com.exercise.RLMarket.mappers.ItemMapper;
import com.exercise.RLMarket.repositories.ItemRepository;
import com.exercise.RLMarket.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemDTO> getItems() {
        return itemRepository.findAll().stream().map(ItemMapper::itemToItemDTO).toList();
    }

    @Override
    public ItemDTO getItem(int id) {
        return ItemMapper.itemToItemDTO(itemRepository.findById(id).orElse(new Item()));
    }
}
