package com.exercise.RLMarket.controllers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.DTOs.TradeDTO;
import com.exercise.RLMarket.services.ItemService;
import com.exercise.RLMarket.services.TradeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class TradeController {
    @Autowired
    TradeService tradeService;
    @Autowired
    ItemService itemService;

    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        TradeDTO tradeDTO = tradeService.getTrade(id);
        if(Objects.equals(userDetails.getUsername(), tradeDTO.getUser().getEmail())){
            tradeService.deleteTrade(id);
        } else {
            System.out.println("failed to delete");
        }

        return "redirect:/trading";
    }

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/trading")
    public String createTradeOffer(Model model) {
        model.addAttribute("trade", new TradeDTO());
        model.addAttribute("trades", tradeService.getAllTrades().stream().sorted(Comparator.comparing(TradeDTO::getDate).reversed()).toList());
        model.addAttribute("items", itemService.getItems());

        return "trades";
    }

    @PostMapping("/submitTrade")
    public String submitTrade(@ModelAttribute(name = "trade") TradeDTO tradeDTO) {
        tradeService.saveTrade(tradeDTO);

        return "redirect:/trading";
    }

}
