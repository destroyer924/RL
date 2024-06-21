package com.exercise.RLMarket.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Entity
@Table(name = "items")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Item {
    @Id
    @Column(name = "item_id")
    private int itemId;
    @Column(name = "item_long_label")
    private String itemLongLabel;
    //    private String itemShortSortLabel;
//    private boolean itemCurrency;
    @Column(name = "item_blueprint")
    private boolean itemBlueprint;
    @Column(name = "item_paintable")
    private boolean itemPaintable;
    @Column(name = "item_slot_index")
    private int slotIndex;
//    private int itemQualityId;
//    private String itemThumbnailAsset;
//    private List<String> itemTradeRestrictions;
}
