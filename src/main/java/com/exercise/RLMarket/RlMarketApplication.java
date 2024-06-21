package com.exercise.RLMarket;

import com.exercise.RLMarket.DTOs.UserDTO;
import com.exercise.RLMarket.enteties.Item;
import com.exercise.RLMarket.enteties.TradeItem;
import com.exercise.RLMarket.enteties.TradeOffer;
import com.exercise.RLMarket.enteties.User;
import com.exercise.RLMarket.repositories.ItemRepository;
import com.exercise.RLMarket.repositories.TradeOfferRepository;
import com.exercise.RLMarket.services.ItemService;
import com.exercise.RLMarket.services.TradeService;
import com.exercise.RLMarket.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class RlMarketApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RlMarketApplication.class, args);

//        TradeOfferRepository tradeOfferRepository = context.getBean(TradeOfferRepository.class);
//        System.out.println(tradeOfferRepository.findTradeOfferByUser(6));
//        ItemService service = context.getBean(ItemService.class);
//        ItemRepository repository = context.getBean(ItemRepository.class);
//        TradeService tradeService = context.getBean(TradeService.class);
//        System.out.println(tradeService.getTradesByUser(6));
//        System.out.println(tradeService.getAllTrades());


//        UserService userService = context.getBean(UserService.class);
//
//        User user = userService.findByEmail("1@1");
//        TradeItem item1 = new TradeItem(2,repository.getReferenceById(24), 23);
//        TradeItem item2 = new TradeItem(3,repository.getReferenceById(25), 12);
//        tradeService.saveTrade(new TradeOffer(2, user, new Date(),item1, item2));
    }
}
