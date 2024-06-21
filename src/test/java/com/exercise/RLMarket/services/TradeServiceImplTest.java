package com.exercise.RLMarket.services;

import com.exercise.RLMarket.DTOs.TradeDTO;
import com.exercise.RLMarket.enteties.TradeItem;
import com.exercise.RLMarket.enteties.TradeOffer;
import com.exercise.RLMarket.enteties.User;
import com.exercise.RLMarket.mappers.ItemMapper;
import com.exercise.RLMarket.mappers.TradeMapper;
import com.exercise.RLMarket.repositories.TradeOfferRepository;
import com.exercise.RLMarket.services.impl.TradeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TradeServiceImplTest {
    @Mock
    private TradeOfferRepository tradeOfferRepository;
    @InjectMocks
    private TradeServiceImpl testService;

    public TradeOffer testTrade1 = TradeOffer.builder()
            .tradeId(1)
            .date(new Date(1635616200000L))
            .giveItem(new TradeItem(1, new ItemServiceImplTest().testItem1, 2))
            .getItem(new TradeItem(2, new ItemServiceImplTest().testItem2, 5))
            .user(new User())
            .build();
    public TradeOffer testTrade2 = TradeOffer.builder()
            .tradeId(2)
            .date(new Date(1635616200000L))
            .giveItem(new TradeItem(5, new ItemServiceImplTest().testItem2, 4))
            .getItem(new TradeItem(3, new ItemServiceImplTest().testItem1, 3))
            .user(new User())
            .build();

    @Test
    public void getTradesTest() {
        List<TradeOffer> test = new ArrayList<>();
        test.add(testTrade1);
        test.add(testTrade2);

        Mockito.when(tradeOfferRepository.findAll()).thenReturn(test);

        List<TradeDTO> trades = testService.getAllTrades();
        assertEquals(test.stream().map(TradeMapper::tradeOfferToTradeDTO).toList(), trades);
    }

    @Test
    public void getTrade() {
        Mockito.when(tradeOfferRepository.findById(1)).thenReturn(Optional.of(testTrade1));

        assertEquals(TradeMapper.tradeOfferToTradeDTO(testTrade1),testService.getTrade(1));
    }

//    @Test
//    public void saveTradeTest() {
//        // Create a sample TradeDTO for testing
//
//
//        // Mock the repository
//        Mockito.when(tradeOfferRepository.save(Mockito.any(TradeOffer.class))).thenReturn(null);
//
//        // Call the saveTrade method
//        testService.saveTrade(tradeDTO1);
//
//        // Verify that the repository's save method was called with the correct parameters
//        Mockito.verify(tradeOfferRepository).save(Mockito.any(TradeOffer.class));
//    }

}
