package com.exercise.RLMarket.services;

import com.exercise.RLMarket.DTOs.TradeDTO;
import com.exercise.RLMarket.enteties.TradeOffer;

import java.util.List;

public interface TradeService {
    void saveTrade(TradeDTO trade);

    void deleteTrade(int tradeId);

    List<TradeDTO> getAllTrades();
    List<TradeDTO> getTradesByUser(int userId);

    TradeDTO getTrade(int id);
}
