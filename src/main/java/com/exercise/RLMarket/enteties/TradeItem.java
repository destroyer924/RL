package com.exercise.RLMarket.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "trade_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TradeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_item_id")
    int id;

    @ManyToOne
    @JoinColumn(name = "item")
    Item item;

    @Column(name = "amount")
    int amount;

    public TradeItem(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }
}
