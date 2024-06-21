package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.TradeDTO;
import com.exercise.RLMarket.enteties.TradeItem;
import com.exercise.RLMarket.enteties.TradeOffer;

public class TradeMapper {
    public static TradeDTO tradeOfferToTradeDTO(TradeOffer tradeOffer) {
        return TradeDTO.builder()
                .id(tradeOffer.getTradeId())
                .date(tradeOffer.getDate())
                .giveItem(ItemMapper.itemToItemDTO(tradeOffer.getGiveItem().getItem()))
                .giveAmount(tradeOffer.getGiveItem().getAmount())
                .getItem(ItemMapper.itemToItemDTO(tradeOffer.getGetItem().getItem()))
                .getAmount(tradeOffer.getGetItem().getAmount())
                .user(UserMapper.userToUserDTO(tradeOffer.getUser()))
                .build();
    }

    public static TradeOffer tradeDTOToTradeOffer(TradeDTO trade) {
        return TradeOffer.builder()
                .tradeId(trade.getId())
                .date(trade.getDate())
                .giveItem(new TradeItem(ItemMapper.itemDTOToItem(trade.getGiveItem()), trade.getGiveAmount()))
                .getItem(new TradeItem(ItemMapper.itemDTOToItem(trade.getGetItem()), trade.getGetAmount()))
//                .giveItem(new TradeItem(1, ItemMapper.itemDTOToItem(trade.getGiveItem()), trade.getGiveAmount()))
//                .getItem(new TradeItem(1, ItemMapper.itemDTOToItem(trade.getGetItem()), trade.getGetAmount()))
                .user(UserMapper.userDTOToUser(trade.getUser()))
                .build();
    }
}
