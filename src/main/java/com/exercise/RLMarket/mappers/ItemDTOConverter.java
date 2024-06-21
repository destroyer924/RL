package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.services.ItemService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemDTOConverter implements Converter<String, ItemDTO> {

    private final ItemService itemService;

    public ItemDTOConverter(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public ItemDTO convert(String source) {
        // Implement the logic to convert the string to ItemDTO using itemService
        return itemService.getItem(Integer.parseInt(source));
    }
}

