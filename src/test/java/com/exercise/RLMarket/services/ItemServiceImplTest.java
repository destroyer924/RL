package com.exercise.RLMarket.services;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.Item;
import com.exercise.RLMarket.mappers.ItemMapper;
import com.exercise.RLMarket.repositories.ItemRepository;
import com.exercise.RLMarket.services.impl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ItemServiceImplTest {
    @Mock
    private ItemRepository itemRepository;
    @InjectMocks
    private ItemServiceImpl serviceTest;

    public Item testItem1 = new Item(1, "Label", false, true, 1);
    public Item testItem2 = new Item(2, "Label2", true, false, 2);
    @Test
    public void getItemsTest() {
        List<Item> test = new ArrayList<>();
        test.add(testItem1);
        test.add(testItem2);

        Mockito.when(itemRepository.findAll()).thenReturn(test);

        List<ItemDTO> items = serviceTest.getItems();
        assertEquals(test.stream().map(ItemMapper::itemToItemDTO).toList(), items);
    }

    @Test
    public void getItemTest() {
        Item test = testItem1;

        Mockito.when(itemRepository.findById(1)).thenReturn(Optional.of(test));

        assertEquals(ItemMapper.itemToItemDTO(test),serviceTest.getItem(1));
    }
}
