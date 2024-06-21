package com.exercise.RLMarket.controllers;

import com.exercise.RLMarket.enteties.User;
import com.exercise.RLMarket.services.TradeService;
import com.exercise.RLMarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    UserService userService;
    TradeService tradeService;
    @Autowired
    public UserController(UserService userService, TradeService tradeService) {
        this.userService = userService;
        this.tradeService = tradeService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "register";
    }

    @GetMapping("/profile/{id}")
    public String profile(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("userTrades",tradeService.getTradesByUser(id));


        return "profile";
    }
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult result, Model model) {
        if (userService.findByEmail(user.getEmail()).getEmail() != null) {
//            result.rejectValue("email", "this email already registered");
//            System.out.println("\n\n\n"+userService.findByEmail(user.getEmail()));
            return "redirect:/register?fail";
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.createUser(user);
        return "redirect:/";
    }

}
