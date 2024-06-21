package com.exercise.RLMarket.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "trade_offers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TradeOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_id")
    private int tradeId;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @Column(name = "date")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "give_item")
    private TradeItem giveItem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "get_item")
    private TradeItem getItem;
}
