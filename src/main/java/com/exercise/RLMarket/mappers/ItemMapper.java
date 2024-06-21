package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.Item;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ItemMapper {
    private static final Map<Integer, String> slotsNames = initSlotsNames();
    private static final Map<String, Integer> biSlotsNames = biInitSlotsNames();

    private static Map<Integer, String> initSlotsNames() {
        Map<Integer, String> slots = new HashMap<>();
        slots.put(16, "Banners");
        slots.put(4, "Antenna");
        slots.put(0, "Bodies");
        slots.put(3, "Boost");
        slots.put(20, "Borders");
        slots.put(5, "Topper");
        slots.put(7, "Paint");
        slots.put(15, "Goal Explosion");
        slots.put(14, "Supersonic Trails");
        slots.put(2, "Wheel");

        return Collections.unmodifiableMap(slots);
    }

    private static Map<String, Integer> biInitSlotsNames() {
        Map<String, Integer> slots = new HashMap<>();
        slots.put("Banners", 16);
        slots.put("Antenna", 4);
        slots.put("Bodies", 0);
        slots.put("Boost", 3);
        slots.put("Borders", 20);
        slots.put("Topper", 5);
        slots.put("Paint", 7);
        slots.put("Goal Explosion", 15);
        slots.put("Supersonic Trails", 14);
        slots.put("Wheel", 2);

        return Collections.unmodifiableMap(slots);
    }

    public static ItemDTO itemToItemDTO(Item item) {
        ItemDTO itemDTO = ItemDTO.builder()
                .id(item.getItemId())
                .itemBlueprint(item.isItemBlueprint())
                .itemPaintable(item.isItemPaintable())
                .itemLongLabel(item.getItemLongLabel())
                .build();

        int slotIndex = item.getSlotIndex();
        if (slotsNames.containsKey(slotIndex)) {
            itemDTO.setItemType(slotsNames.get(slotIndex));
        } else {
            itemDTO.setItemType(""+ slotIndex);
        }

        return itemDTO;
    }

    public static Item itemDTOToItem(ItemDTO itemDTO) {
        Item item = Item.builder()
                .itemId(itemDTO.getId())
                .itemBlueprint(itemDTO.isItemBlueprint())
                .itemPaintable(itemDTO.isItemPaintable())
                .itemLongLabel(itemDTO.getItemLongLabel())
                .build();

        String itemType = itemDTO.getItemType();

        if(biSlotsNames.containsKey(itemType)) {
            item.setSlotIndex(biSlotsNames.get(itemType));
        } else {
            item.setItemId(Integer.getInteger(itemType));
        }

        return item;
    }

    public static String itemImageUrl(ItemDTO item) {
        return "https://github.com/enzanki-ars/rocket-league-item-images/tree/enzanki-ars/Rocket%20League%20Item%20Images/" + item.getItemType() + "/" + item.getItemLongLabel().replace(" ", "%20") + "/Default.png";
    }

}
