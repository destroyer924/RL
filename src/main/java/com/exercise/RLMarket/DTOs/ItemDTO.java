package com.exercise.RLMarket.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ItemDTO {
    private int id;
    private String itemLongLabel;
    private boolean itemBlueprint;
    private boolean itemPaintable;
    private String itemType;
}
