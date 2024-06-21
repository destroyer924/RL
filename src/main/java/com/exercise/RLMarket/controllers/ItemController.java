package com.exercise.RLMarket.controllers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ItemController {
    ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public String getItems(Model model) {
        model.addAttribute("items", itemService.getItems());
        return "items";
    }

    @GetMapping("/item/{id}")
    public String getItem(Model model, @PathVariable int id) {
        model.addAttribute("item", itemService.getItem(id));
        return "item";
    }

    @GetMapping("/trade")
    public String createTradeOffer(Model model) {
        model.addAttribute("allItems", itemService.getItems());

        return "tradeForm";
    }
}
